package com.yourname.yourmod.loader.forge;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ForgeRegistriesImpl {

    private ForgeRegistriesImpl() {}

    public static void registerItem(String name, Object item) {
        // 実装簡略化（完全版は後で DeferredRegister 化）
    }

    public static void registerBlock(String name, Object block) {
    }

    public static void registerEntity(String name, Object entity) {
    }

    public static void registerBlockEntity(String name, Object blockEntity) {
    }
}
