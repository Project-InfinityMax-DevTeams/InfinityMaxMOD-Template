package com.yourname.yourmod.api.libs;

import com.yourname.yourmod.loader.Platform;

public final class ModRegistries {

    private ModRegistries() {}

    public static void registerItem(String id, Object item) {
        Platform.get().registries().item(id, item);
    }

    public static void registerBlock(String id, Object block) {
        Platform.get().registries().block(id, block);
    }

    public static void registerEntity(String id, Object entityType) {
        Platform.get().registries().entity(id, entityType);
    }

    public static void registerBlockEntity(String id, Object blockEntityType) {
        Platform.get().registries().blockEntity(id, blockEntityType);
    }
}