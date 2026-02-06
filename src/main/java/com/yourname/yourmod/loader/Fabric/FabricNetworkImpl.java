package com.yourname.yourmod.loader.fabric;

import com.yourname.yourmod.loader.LoaderExpectPlatform;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ClientPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public final class FabricNetworkImpl implements LoaderExpectPlatform.Network {

    private static final ResourceLocation CHANNEL_ID =
            new ResourceLocation("yourmodid", "main");

    @Override
    public void register() {
        // ServerPlayNetworking.registerGlobalReceiver(...)
    }

    @Override
    public void sendToServer(Object packet) {
        ClientPlayNetworking.send(CHANNEL_ID, ((net.minecraft.network.FriendlyByteBuf) packet));
    }

    @Override
    public void sendToPlayer(Object packet, Object player) {
        ServerPlayNetworking.send(
                (net.minecraft.server.level.ServerPlayer) player,
                CHANNEL_ID,
                ((net.minecraft.network.FriendlyByteBuf) packet)
        );
    }
}