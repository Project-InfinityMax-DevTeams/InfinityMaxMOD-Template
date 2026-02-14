package com.yourname.yourmod.loader.forge;

import com.yourname.yourmod.api.event.CommonEvents;
import com.yourname.yourmod.loader.LoaderExpectPlatform;

public final class ForgeEventsImpl implements LoaderExpectPlatform.Events {

    @Override
    public void register() {
    }

    @Override
    public void onPlayerJoin(Object player) {
        CommonEvents.onPlayerJoin(player);
    }
}
