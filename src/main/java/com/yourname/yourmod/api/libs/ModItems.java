package com.yourname.yourmod.api.libs;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

/**
 * アイテム登録API
 */
public final class ModItems {

    private ModItems() {}

    public static Item register(String name, Supplier<Item> item) {
        return ModRegistries.registerItem(name, item);
    }
}
