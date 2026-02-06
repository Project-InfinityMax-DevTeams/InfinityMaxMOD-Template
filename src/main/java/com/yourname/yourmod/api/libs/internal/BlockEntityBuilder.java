package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.libs.ModRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public final class BlockEntityBuilder<T extends BlockEntity> {

    private final String id;
    private final BlockEntityType.BlockEntitySupplier<T> factory;
    private Block[] blocks;

    public BlockEntityBuilder(String id, BlockEntityType.BlockEntitySupplier<T> factory) {
        this.id = id;
        this.factory = factory;
    }

    public BlockEntityBuilder<T> blocks(Block... blocks) {
        this.blocks = blocks;
        return this;
    }

    public BlockEntityType<T> build() {
        if (blocks == null || blocks.length == 0) {
            throw new IllegalStateException("BlockEntity must have at least one block");
        }

        BlockEntityType<T> type =
                BlockEntityType.Builder.of(factory, blocks).build(null);

        ModRegistries.registerBlockEntity(id, type);
        return type;
    }
}