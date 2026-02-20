package com.yuyuto.infinitymaxapi.api.libs;

import com.yuyuto.infinitymaxapi.api.event.EventPriority;
import com.yuyuto.infinitymaxapi.api.event.ModEvent;
import com.yuyuto.infinitymaxapi.api.event.PlayerJoinEvent;
import com.yuyuto.infinitymaxapi.api.libs.internal.EventBuilder;

public final class Events {

    private Events() {}

    public static <T extends ModEvent> EventBuilder<T> on(Class<T> eventClass) {
        return new EventBuilder<>(eventClass);
    }

    public static EventBuilder<PlayerJoinEvent> playerJoin() {
        return on(PlayerJoinEvent.class);
    }
}
