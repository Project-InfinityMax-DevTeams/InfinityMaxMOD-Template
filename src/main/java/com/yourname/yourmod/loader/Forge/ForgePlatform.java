package com.yourname.yourmod.loader.forge;

import com.yourname.yourmod.loader.LoaderExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public final class ForgePlatform implements LoaderExpectPlatform {

    private final Registries registries = new ForgeRegistriesImpl();
    private final Network network = new ForgeNetworkImpl();
    private final Events events = new ForgeEventsImpl();

    private static final String MOD_ID = "yourmodid";

    @Override
    public ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Override
    public boolean isClient() {
        return FMLEnvironment.dist == Dist.CLIENT;
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
}