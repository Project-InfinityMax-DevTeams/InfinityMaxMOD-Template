package com.yourname.yourmod.loader;

import net.minecraft.resources.ResourceLocation;

/**
 * Forge / Fabric / NeoForge 差分を吸収するための期待API
 * 共通コードはこのinterface「だけ」を見る
 */
public interface LoaderExpectPlatform {

    /* ------------------------------------------------------------ */
    /* 基本情報 */
    /* ------------------------------------------------------------ */

    /**
     * MOD ID を自動付与した ResourceLocation を生成する
     */
    ResourceLocation id(String path);

    /**
     * 現在の実行環境が Client 側かどうか
     */
    boolean isClient();


    /* ------------------------------------------------------------ */
    /* Registry */
    /* ------------------------------------------------------------ */

    Registries registries();

    interface Registries {
        void item(String name, Object item);
        void block(String name, Object block);
        void entity(String name, Object entityType);
        void blockEntity(String name, Object blockEntityType);
    }


    /* ------------------------------------------------------------ */
    /* Network */
    /* ------------------------------------------------------------ */

    Network network();

    interface Network {
        /**
         * Packet登録など初期化処理
         */
        void register();

        /**
         * Client → Server
         */
        void sendToServer(Object packet);

        /**
         * Server → Client
         */
        void sendToPlayer(Object player, Object packet);
    }


    /* ------------------------------------------------------------ */
    /* Events */
    /* ------------------------------------------------------------ */

    Events events();

    interface Events {
        /**
         * Event登録の入口
         */
        void register();

        /**
         * プレイヤー参加イベント
         */
        void onPlayerJoin(Object player);
    }
    interface DataGen{
        void datagen();
    }
}