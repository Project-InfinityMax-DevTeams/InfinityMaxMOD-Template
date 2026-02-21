package com.yuyuto.infinitymaxapi.api.client;

import com.yuyuto.infinitymaxapi.api.lifecycle.LifecycleRegistry;
import com.yuyuto.infinitymaxapi.api.lifecycle.ModLifecycle;

public final class Client {

    private Client() {}

    public static void init() {
        LifecycleRegistry.register(ModLifecycle.CLIENT_INIT, () -> consumer.accept(new ClientContext()));
    }
}