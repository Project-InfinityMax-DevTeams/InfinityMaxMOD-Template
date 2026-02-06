package com.yourname.yourmod.api.libs;

import net.minecraft.server.level.ServerPlayer;

/**
 * MOD共通ネットワークAPI
 */
public final class ModNetwork {

    private ModNetwork() {}

    /** 初期化（MOD起動時に1回） */
    public static void init() {
        // TODO: Forge SimpleChannel / Fabric Networking 初期化
    }

    /** サーバーへ送信 */
    public static void sendToServer(Object packet) {
        // TODO
    }

    /** クライアントへ送信 */
    public static void sendToClient(ServerPlayer player, Object packet) {
        // TODO
    }
}
