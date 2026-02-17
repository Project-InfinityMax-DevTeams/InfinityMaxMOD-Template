package com.yourname.yourmod.loader;

import com.yourname.yourmod.api.libs.internal.*;

public final class Platform {
    private static final Platform INSTANCE = new Platform();
    private final Registries registries = new Registries();

    private Platform() {}

    public static Platform get() {
        return INSTANCE;
    }

    public Registries registries() {
        return registries;
    }

    public static final class Registries {
        public <T> void item(String id, T item) {
            Platform.get().registries().item(id, item);
        }

        public <T> void block(String id, T block) {
            Platform.get().registries().block(id, block);
        }

        public <T, C> void entity(String id, T entity, C category, float width, float height) {
            Platform.get().registries().entity(id, entityType, category, width, height);
        }

        public <T, B> void blockEntity(String id, T entity, B... blocks) {
            Platform.get().registries().blockEntity(id, blockEntityType, blocks);
        }
    }
}
