package com.yourname.yourmod.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ログ出力統一
 */
public final class LogUtil {

    private static final Logger LOGGER =
            LoggerFactory.getLogger("YourMod");

    private LogUtil() {}

    public static void info(String msg) {
        LOGGER.info(msg);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
    }
}
