package com.yourname.yourmod.api.libs;

import com.yourname.yourmod.api.libs.internal.BlockBuilder;
import com.yourname.yourmod.api.libs.internal.BlockEntityBuilder;
import com.yourname.yourmod.api.libs.internal.EntityBuilder;
import com.yourname.yourmod.api.libs.internal.ItemBuilder;
import java.util.function.Supplier;

public final class Registry {

    private Registry() {}

    public static ItemBuilder item(String id) {
        return new ItemBuilder(id);
    }

    public static BlockBuilder block(String id) {
        return new BlockBuilder(id);
    }

    public static <T,C> EntityBuilder<T,C> entity(String id, Supplier<T> factory) {
        return new EntityBuilder<>(id, factory);
    }

    public static <T> BlockEntityBuilder<T> blockEntity(String id, Supplier<T> factory) {
        return new BlockEntityBuilder<>(id, factory);
    }
}