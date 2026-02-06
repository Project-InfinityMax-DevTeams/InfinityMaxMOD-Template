package com.yourname.yourmod.loader;

import net.minecraft.resources.ResourceLocation;

public interface LoaderExpectPlatform {

    ResourceLocation id(String path);

    void registerItem(String name, Object item);
    void registerBlock(String name, Object block);
    void registerEntity(String name, Object entity);
    void registerBlockEntity(String name, Object blockEntity);

    void initNetwork();
    void sendToServer(Object packet);
    void sendToClient(Object player, Object packet);

    void registerEvents();
}

package com.yourname.yourmod.loader;