package com.yuyuto.infinitymaxapi;

import com.yuyuto.infinitymaxapi.InfinityMaxAPI;
import net.fabricmc.api.ModInitiallizer;

public class InfinityMaxAPIFabric implements ModInitiallizer {
    @Override
    public void onInitializer() {
        InfinityMaxAPI.init();
    }
}