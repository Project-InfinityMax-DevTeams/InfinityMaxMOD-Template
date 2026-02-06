package com.yourname.yourmod.api.libs.packet;

import com.yourname.yourmod.loader.Platform;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Function;

public final class Packet<T> {

    private final String id;
    private PacketDirection direction;
    private Function<FriendlyByteBuf, T> decoder;
    private SimplePacket.PacketEncoder<T> encoder;
    private PacketHandler<T> handler;

    private Packet(String id) {
        this.id = id;
    }

    public static <T> Packet<T> define(String id) {
        return new Packet<>(id);
    }

    public Packet<T> serverbound() {
        this.direction = PacketDirection.C2S;
        return this;
    }

    public Packet<T> clientbound() {
        this.direction = PacketDirection.S2C;
        return this;
    }

    public Packet<T> codec(
            Function<FriendlyByteBuf, T> decoder,
            SimplePacket.PacketEncoder<T> encoder
    ) {
        this.decoder = decoder;
        this.encoder = encoder;
        return this;
    }

    public Packet<T> handle(PacketHandler<T> handler) {
        this.handler = handler;
        return this;
    }

    public void register() {
        PacketRegistry.register(new SimplePacket<>(
                id, direction, decoder, encoder, handler
        ));
    }

    /* ------------------ DSL SEND ------------------ */

    public void sendToServer(T packet) {
        Platform.get().network().sendToServer(packet);
    }

    public void sendToPlayer(Object player, T packet) {
        Platform.get().network().sendToPlayer(player, packet);
    }
}