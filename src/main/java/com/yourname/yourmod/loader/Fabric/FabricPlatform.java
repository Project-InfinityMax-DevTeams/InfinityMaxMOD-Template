package com.yourname.yourmod.loader.fabric;

import com.yourname.yourmod.loader.LoaderExpectPlatform;
import com.yourname.yourmod.loader.LoaderExpectPlatform.Client;
import com.yourname.yourmod.api.datagen.DataGen;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public final class FabricPlatform implements LoaderExpectPlatform {

    private static final String MOD_ID = "yourmodid";

    private final Registries registries = new FabricRegistriesImpl();
    private final Network network = new FabricNetworkImpl();
    private final Events events = new FabricEventsImpl();

    private final Client client =
            FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT
                    ? new FabricClientImpl()
                    : Client.noop();

    private final DataGen dataGen = new FabricDataGenImpl();

    @Override
    public ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Override
    public boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public Registries registries() {
        return registries;
    }

    @Override
    public Network network() {
        return network;
    }

    @Override
    public Events events() {
        return events;
    }

    @Override
    public Client client() {
        return client;
    }

    @Override
    public DataGen dataGen() {
        return dataGen;
    }
}