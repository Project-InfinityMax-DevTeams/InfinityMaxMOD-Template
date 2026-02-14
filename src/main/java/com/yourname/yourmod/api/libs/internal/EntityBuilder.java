package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.libs.ModRegistries;
import java.util.function.Supplier;

public final class EntityBuilder<T> {

    private final String id;
    private final Supplier<T> factory;

    public EntityBuilder(String id, Supplier<T> factory) {
        this.id = id;
        this.factory = factory;
    }

    public EntityBuilder<T> category(Object category) {
        return this;
    }

    public EntityBuilder<T> size(float width, float height) {
        return this;
    }

    public T build() {
        T entity = factory.get();
        ModRegistries.registerEntity(id, entity);
        return entity;
    }
}
