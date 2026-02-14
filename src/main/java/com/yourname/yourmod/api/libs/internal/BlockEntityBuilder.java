package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.libs.ModRegistries;
import java.util.function.Supplier;

public final class BlockEntityBuilder<T> {

    private final String id;
    private final Supplier<T> factory;

    public BlockEntityBuilder(String id, Supplier<T> factory) {
        this.id = id;
        this.factory = factory;
    }

    public BlockEntityBuilder<T> blocks(Object... blocks) {
        return this;
    }

    public T build() {
        T blockEntity = factory.get();
        ModRegistries.registerBlockEntity(id, blockEntity);
        return blockEntity;
    }
}
