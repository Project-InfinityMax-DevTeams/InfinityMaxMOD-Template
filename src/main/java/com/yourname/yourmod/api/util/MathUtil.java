package com.yourname.yourmod.api.util;

/**
 * 数学系ユーティリティ
 */
public final class MathUtil {

    private MathUtil() {}

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
