package com.yourname.yourmod.api.libs;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * ブロック登録API
 */
public final class ModBlocks {

    private ModBlocks() {}

    public static Block register(String name, Supplier<Block> block) {
        return ModRegistries.registerBlock(name, block);
    }
}
