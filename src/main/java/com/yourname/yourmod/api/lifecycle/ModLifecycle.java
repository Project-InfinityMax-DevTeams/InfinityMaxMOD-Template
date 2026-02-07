package com.yourname.yourmod.api.lifecycle;

/**
 * MOD 全体の初期化ライフサイクル定義
 * すべての処理は必ずどれかの段階に属する
 */
public enum ModLifecycle {

    /** クラスロード直後・定数初期化のみ */
    CONSTRUCT,

    /** Forge / Fabric 共通の初期化 */
    COMMON_INIT,

    /** クライアント専用初期化（Render / Screen / HUD 等） */
    CLIENT_INIT,

    /** サーバー専用初期化 */
    SERVER_INIT,

    /** DataGenerator 実行時 */
    DATAGEN
}