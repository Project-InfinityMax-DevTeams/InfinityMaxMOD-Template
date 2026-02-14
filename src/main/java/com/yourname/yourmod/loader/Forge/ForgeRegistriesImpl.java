package com.yourname.yourmod.loader.forge;

import com.yourname.yourmod.loader.LoaderExpectPlatform;
import java.util.HashMap;
import java.util.Map;

public final class ForgeRegistriesImpl implements LoaderExpectPlatform.Registries {

    private final Map<String, Object> items = new HashMap<>();
    private final Map<String, Object> blocks = new HashMap<>();
    private final Map<String, Object> entities = new HashMap<>();
    private final Map<String, Object> blockEntities = new HashMap<>();

    @Override
    public void item(String name, Object item) {
        items.put(name, item);
    }

    @Override
    public void block(String name, Object block) {
        blocks.put(name, block);
    }

    @Override
    public void entity(String name, Object entityType) {
        entities.put(name, entityType);
    }

    @Override
    public void blockEntity(String name, Object blockEntityType) {
        blockEntities.put(name, blockEntityType);
    }
}
