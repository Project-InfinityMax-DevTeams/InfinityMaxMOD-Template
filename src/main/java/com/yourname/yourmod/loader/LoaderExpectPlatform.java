package com.yourname.yourmod.loader;

import net.minecraft.resources.ResourceLocation;

public interface LoaderExpectPlatform {

    ResourceLocation id(String path);
    boolean isClient();

    Registries registries();
    Network network();
    Events events();
    Client client(); // ★追加

    /* ---------------- Registry ---------------- */

    interface Registries {
        void item(String name, Object item);
        void block(String name, Object block);
        void entity(String name, Object entityType);
        void blockEntity(String name, Object blockEntityType);
    }

    /* ---------------- Network ---------------- */

    interface Network {
        void register();
        void sendToServer(Object packet);
        void sendToPlayer(Object player, Object packet);
    }

    /* ---------------- Events ---------------- */

    interface Events {
        void register();
        void onPlayerJoin(Object player);
    }

    /* ---------------- Client ---------------- */

    interface Client {
        void init();

        /** Server用 no-op */
        static Client noop() {
            return () -> {};
        }
    }
}