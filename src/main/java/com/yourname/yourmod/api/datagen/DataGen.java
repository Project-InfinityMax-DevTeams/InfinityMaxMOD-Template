package com.yourname.yourmod.api.datagen;

public interface DataGen {

    BlockGen block(String id);
    ItemGen item(String id);
    EntityGen entity(String id);
}