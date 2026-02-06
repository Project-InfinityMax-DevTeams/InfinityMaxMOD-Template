package com.yourname.yourmod.loader.fabric;

import com.yourname.yourmod.api.datagen.DataGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public final class FabricDataGenImpl implements DataGen {

    private FabricDataGenerator generator;

    /**
     * Fabric Entrypoint から注入される
     */
    public void setup(FabricDataGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void block(String id, Model model, Loot loot, List<TagKey<?>> tags) {
        generator.addProvider((output, registries) ->
            new FabricModelProvider(output) {
                @Override
                public void generateBlockStateModels(BlockStateModelGenerator gen) {
                    model.generateBlock(gen, id);
                }

                @Override
                public void generateItemModels(ItemModelGenerator gen) {}
            }
        );

        generator.addProvider((output, registries) ->
            new FabricBlockLootTableProvider(output, registries) {
                @Override
                public void generate() {
                    loot.generateBlock(this, id);
                }
            }
        );
    }

    @Override
    public void item(String id, Model model, List<TagKey<?>> tags, String lang) {
        generator.addProvider((output, registries) ->
            new FabricModelProvider(output) {
                @Override
                public void generateBlockStateModels(BlockStateModelGenerator gen) {}

                @Override
                public void generateItemModels(ItemModelGenerator gen) {
                    model.generateItem(gen, id);
                }
            }
        );

        generator.addProvider((output, registries) ->
            new FabricLanguageProvider(output, "en_us") {
                @Override
                protected void generateTranslations(RegistryWrapper.WrapperLookup lookup) {
                    add(id, lang);
                }
            }
        );
    }

    @Override
    public void entity(String id, Loot loot, String lang) {
        generator.addProvider((output, registries) ->
            new FabricLanguageProvider(output, "en_us") {
                @Override
                protected void generateTranslations(RegistryWrapper.WrapperLookup lookup) {
                    add(id, lang);
                }
            }
        );
    }
}