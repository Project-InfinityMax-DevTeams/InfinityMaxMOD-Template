package com.yourname.yourmod.api.libs;

import java.util.function.Supplier;

public final class ModBlocks {

    private ModBlocks() {}

    public static <T> T register(String name, Supplier<T> block) {
        T value = block.get();
        ModRegistries.registerBlock(name, value);
        return value;
    }
}
