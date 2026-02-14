package com.yourname.yourmod.api.libs;

import java.util.function.Supplier;

public final class ModItems {

    private ModItems() {}

    public static <T> T register(String name, Supplier<T> item) {
        T value = item.get();
        ModRegistries.registerItem(name, value);
        return value;
    }
}
