package com.yourname.yourmod.api.libs;

import com.yourname.yourmod.loader.Platform;
import java.util.function.Supplier;

public final class ModRegistries {

    private ModRegistries() {}

    public static <T> T registerItem(String name, Supplier<T> supplier) {
        T item = supplier.get();
        Platform.get().registerItem(name, item);
        return item;
    }

    public static <T> T registerBlock(String name, Supplier<T> supplier) {
        T block = supplier.get();
        Platform.get().registerBlock(name, block);
        return block;
    }

    public static <T> T registerEntity(String name, Supplier<T> supplier) {
        T entity = supplier.get();
        Platform.get().registerEntity(name, entity);
        return entity;
    }

    public static <T> T registerBlockEntity(String name, Supplier<T> supplier) {
        T be = supplier.get();
        Platform.get().registerBlockEntity(name, be);
        return be;
    }
}
