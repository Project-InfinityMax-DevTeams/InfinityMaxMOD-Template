package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.libs.ModRegistries;

public final class BlockBuilder {

    private final String id;
    private Object template;

    public BlockBuilder(String id) {
        this.id = id;
    }

    public BlockBuilder template(Object template) {
        this.template = template;
        return this;
    }

    public BlockBuilder strength(float value) {
        return this;
    }

    public BlockBuilder noOcclusion() {
        return this;
    }

    public Object build() {
        Object block = template != null ? template : new Object();
        ModRegistries.registerBlock(id, block);
        return block;
    }
}
