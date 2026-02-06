package com.yourname.yourmod.api.util;

/**
 * MOD ID補助
 */
public final class IdUtil {

    private static final String MODID = "yourmod";

    public static String id(String path) {
        return MODID + ":" + path;
    }
}
