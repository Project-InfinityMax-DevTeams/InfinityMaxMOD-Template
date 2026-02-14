package com.yourname.yourmod.api.libs;

import java.util.function.Supplier;

public final class ModBlockEntities {

    private ModBlockEntities() {}

    public static <T> T register(String name, Supplier<T> blockEntity) {
        T value = blockEntity.get();
        ModRegistries.registerBlockEntity(name, value);
        return value;
    }
}
