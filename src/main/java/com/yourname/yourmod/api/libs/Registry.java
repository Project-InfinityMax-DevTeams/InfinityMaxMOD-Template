package com.yourname.yourmod.api.libs;

import com.yourname.yourmod.api.libs.internal.*;

import net.minecraft.world.entity.Entity;

public final class Registry {

    private Registry() {}

    public static ItemBuilder item(String id) {
        return new ItemBuilder(id);
    }

    public static BlockBuilder block(String id) {
        return new BlockBuilder(id);
    }

    public static <T extends Entity> EntityBuilder<T> entity(
            String id,
            net.minecraft.world.entity.EntityType.EntityFactory<T> factory
    ) {
        return new EntityBuilder<>(id, factory);
    }

    public static <T extends net.minecraft.world.level.block.entity.BlockEntity>
    BlockEntityBuilder<T> blockEntity(
            String id,
            net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier<T> factory
    ) {
        return new BlockEntityBuilder<>(id, factory);
    }
}