package com.yourname.yourmod.loader.fabric;

import com.yourname.yourmod.loader.LoaderExpectPlatform;
import net.minecraft.resources.ResourceLocation;

public class FabricPlatform implements LoaderExpectPlatform {

    @Override
    public ResourceLocation id(String path) {
        return new ResourceLocation("yourmod", path);
    }

    @Override
    public void registerItem(String name, Object item) {
        FabricRegistriesImpl.registerItem(name, item);
    }

    @Override
    public void registerBlock(String name, Object block) {
        FabricRegistriesImpl.registerBlock(name, block);
    }

    @Override
    public void registerEntity(String name, Object entity) {
        FabricRegistriesImpl.registerEntity(name, entity);
    }

    @Override
    public void registerBlockEntity(String name, Object blockEntity) {
        FabricRegistriesImpl.registerBlockEntity(name, blockEntity);
    }

    @Override
    public void initNetwork() {
        FabricNetworkImpl.init();
    }

    @Override
    public void sendToServer(Object packet) {
        FabricNetworkImpl.sendToServer(packet);
    }

    @Override
    public void sendToClient(Object player, Object packet) {
        FabricNetworkImpl.sendToClient(player, packet);
    }

    @Override
    public void registerEvents() {
        FabricEventsImpl.register();
    }
}