package com.yourname.yourmod.api.libs;

import java.util.function.Supplier;

public final class ModEntities {

    private ModEntities() {}

    public static <T> T register(String name, Supplier<T> entity) {
        T value = entity.get();
        ModRegistries.registerEntity(name, value);
        return value;
    }
}
