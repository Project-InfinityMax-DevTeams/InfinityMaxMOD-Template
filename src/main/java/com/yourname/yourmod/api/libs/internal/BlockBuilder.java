package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.libs.ModRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public final class BlockBuilder {

    private final String id;
    private BlockBehaviour.Properties properties =
            BlockBehaviour.Properties.of(Material.STONE);

    public BlockBuilder(String id) {
        this.id = id;
    }

    public BlockBuilder material(Material material) {
        properties = BlockBehaviour.Properties.of(material);
        return this;
    }

    public BlockBuilder strength(float value) {
        properties.strength(value);
        return this;
    }

    public BlockBuilder noOcclusion() {
        properties.noOcclusion();
        return this;
    }

    public Block build() {
        Block block = new Block(properties);
        ModRegistries.registerBlock(id, block);
        return block;
    }
}