package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.libs.ModRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public final class ItemBuilder {

    private final String id;
    private final Item.Properties properties = new Item.Properties();

    public ItemBuilder(String id) {
        this.id = id;
    }

    /** スタック数 */
    public ItemBuilder stack(int size) {
        properties.stacksTo(size);
        return this;
    }

    /** クリエイティブタブ */
    public ItemBuilder tab(CreativeModeTab tab) {
        properties.tab(tab);
        return this;
    }

    /** 耐久値 */
    public ItemBuilder durability(int value) {
        properties.durability(value);
        return this;
    }

    /** 登録実行 */
    public Item build() {
        Item item = new Item(properties);
        ModRegistries.registerItem(id, item);
        return item;
    }
}