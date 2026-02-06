package com.yourname.yourmod.api.libs;

import java.util.function.Supplier;

/**
 * ブロックエンティティ登録API
 */
public final class ModBlockEntities {

    private ModBlockEntities() {}

    public static <T> T register(String name, Supplier<T> blockEntity) {
        return ModRegistries.registerBlockEntity(name, blockEntity);
    }
}
