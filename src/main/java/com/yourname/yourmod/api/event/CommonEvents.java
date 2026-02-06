package com.yourname.yourmod.api.event;

import net.minecraft.world.entity.player.Player;

/**
 * MOD共通イベント定義
 */
public final class CommonEvents {

    private CommonEvents() {}

    /** プレイヤーがログインした時 */
    public static void onPlayerJoin(Player player) {
        // content側がここを使う
    }

    /** ワールドロード時 */
    public static void onWorldLoad() {
    }
}
