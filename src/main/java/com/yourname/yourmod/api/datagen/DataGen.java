package com.yourname.yourmod.api.datagen;

import com.yourname.yourmod.api.libs.datagen.BlockGen;
import com.yourname.yourmod.api.libs.datagen.EntityGen;
import com.yourname.yourmod.api.libs.datagen.ItemGen;

public interface DataGen {

    BlockGen block(String id);
    ItemGen item(String id);
    EntityGen entity(String id);
}
