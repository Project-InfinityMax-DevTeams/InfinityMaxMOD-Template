package com.yourname.yourmod.api.libs;

import com.yourname.yourmod.api.event.EventPriority;
import com.yourname.yourmod.api.event.ModEvent;
import com.yourname.yourmod.api.event.PlayerJoinEvent;
import com.yourname.yourmod.api.libs.internal.EventBuilder;

public final class Events {

    private Events() {}

    public static <T extends ModEvent> EventBuilder<T> on(Class<T> eventClass) {
        return new EventBuilder<>(eventClass);
    }

    public static EventBuilder<PlayerJoinEvent> playerJoin() {
        return on(PlayerJoinEvent.class);
    }
}
