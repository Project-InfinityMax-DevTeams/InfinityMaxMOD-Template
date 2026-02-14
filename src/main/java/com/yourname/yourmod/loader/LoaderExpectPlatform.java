package com.yourname.yourmod.loader;

public interface LoaderExpectPlatform {

    String id(String path);
    boolean isClient();

    Registries registries();
    Network network();
    Events events();

    interface Registries {
        void item(String name, Object item);
        void block(String name, Object block);
        void entity(String name, Object entityType);
        void blockEntity(String name, Object blockEntityType);
    }

    interface Network {
        void register();
        void sendToServer(Object packet);
        void sendToPlayer(Object player, Object packet);
    }

    interface Events {
        void register();
        void onPlayerJoin(Object player);
    }
}
