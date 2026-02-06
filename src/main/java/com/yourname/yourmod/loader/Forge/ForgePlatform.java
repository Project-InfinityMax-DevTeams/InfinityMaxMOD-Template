package com.yourname.yourmod.loader.forge;

import com.yourname.yourmod.loader.LoaderExpectPlatform;
import net.minecraft.resources.ResourceLocation;

public class ForgePlatform implements LoaderExpectPlatform {

    @Override
    public ResourceLocation id(String path) {
        return new ResourceLocation("yourmod", path);
    }

    @Override
    public void registerItem(String name, Object item) {
        ForgeRegistriesImpl.registerItem(name, item);
    }

    @Override
    public void registerBlock(String name, Object block) {
        ForgeRegistriesImpl.registerBlock(name, block);
    }

    @Override
    public void registerEntity(String name, Object entity) {
        ForgeRegistriesImpl.registerEntity(name, entity);
    }

    @Override
    public void registerBlockEntity(String name, Object blockEntity) {
        ForgeRegistriesImpl.registerBlockEntity(name, blockEntity);
    }

    @Override
    public void initNetwork() {
        ForgeNetworkImpl.init();
    }

    @Override
    public void sendToServer(Object packet) {
        ForgeNetworkImpl.sendToServer(packet);
    }

    @Override
    public void sendToClient(Object player, Object packet) {
        ForgeNetworkImpl.sendToClient(player, packet);
    }

    @Override
    public void registerEvents() {
        ForgeEventsImpl.register();
    }
}
