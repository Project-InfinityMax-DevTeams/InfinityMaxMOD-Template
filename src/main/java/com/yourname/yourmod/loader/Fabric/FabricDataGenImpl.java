package com.yourname.yourmod.loader.fabric;

import com.yourname.yourmod.api.libs.datagen.BlockGen;
import com.yourname.yourmod.api.libs.datagen.DataGen;
import com.yourname.yourmod.api.libs.datagen.EntityGen;
import com.yourname.yourmod.api.libs.datagen.ItemGen;

public final class FabricDataGenImpl implements com.yourname.yourmod.api.datagen.DataGen {

    @Override
    public BlockGen block(String id) {
        return DataGen.block(id);
    }

    @Override
    public ItemGen item(String id) {
        return DataGen.item(id);
    }

    @Override
    public EntityGen entity(String id) {
        return DataGen.entity(id);
    }
}
