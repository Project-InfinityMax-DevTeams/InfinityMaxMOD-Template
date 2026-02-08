# MOD カスタムシステム設計ガイド（MOD 固有の開発システムの作り方）
この章では、
**ブロック・アイテム・エンティティなどの“素材”を組み合わせて、
MOD 独自のゲームシステムをどう構築するか** を解説します。

DSL は「登録」のための道具です。
**ゲーム性は DSL の外側で作る**──ここが一番重要です。

## 1. MOD における「カスタムシステム」とは何か

### 1.1 定義

本 MDK における **カスタムシステム** とは、

* MOD 独自のルール
* MOD 独自の進行
* MOD 独自の内部状態
* MOD 独自の相互作用

を **Minecraft の標準仕様とは独立して** 実装したものを指します。

### 1.2 具体例

* 魔力 / エネルギー / 圧力 / 放射線 などの独自数値
* 機械ネットワーク / 電力網 / 流体網
* スキルツリー / 成長システム
* ワールド状態（侵食・汚染・文明度）
* 国家・勢力・陣営システム
* 独自 AI ロジック

これらは **Block / Item / Entity ではない**
しかし **それらを材料として動く**。

## 2. 大原則：DSL とカスタムシステムの分離

### 2.1 絶対ルール

| やること                             | 書く場所              |
| -------------------------------- | ----------------- |
| 登録（Block, Item, Event, Client 等） | DSL               |
| ロジック（計算・判定・状態遷移）                 | カスタムシステム          |
| 状態の保存                            | Capability / Data |
| 表示                               | Client            |

**DSL にロジックを書いてはいけない。**

## 3. 推奨ディレクトリ構成（システム用）

```
src/main/java/com/example/mymod/
├── content/          ← DSL登録専用
├── client/           ← Client DSL
├── datagen/          ← DataGen DSL
├── system/           ← ★ここからが主役
│   ├── energy/
│   │   ├── EnergySystem.java
│   │   ├── EnergyNetwork.java
│   │   └── EnergyCalculator.java
│   ├── skill/
│   │   ├── SkillSystem.java
│   │   ├── SkillTree.java
│   │   └── SkillRuntime.java
│   ├── world/
│   │   ├── WorldState.java
│   │   └── WorldTickHandler.java
│   └── api/
│       └── ModSystems.java
└── logic/
    └── events/       ← Event DSL から呼ばれる
```

## 4. システム構築の正しい順番（超重要）

### 結論（先に出す）

**① 定義 → ② 状態 → ③ 計算 → ④ イベント接続 → ⑤ 表示**

この順番を崩すと、必ず破綻する。

## 5. ステップ①：システムの「定義」を書く

### 5.1 目的

* このシステムは何を扱うのか
* 何が入力で、何が出力か
* Minecraft の何に影響するか

### 5.2 書くファイル

```java
package com.example.mymod.system.energy;

public final class EnergySystem {

    private EnergySystem() {}

    public static final int MAX_ENERGY = 1_000_000;
}
```

ここでは **処理を書かない**。
「存在を宣言する」だけ。

## 6. ステップ②：状態（State / Data）を書く

### 6.1 原則

* 状態 = **保存されるもの**
* 計算 = **保存しない**

### 6.2 例：プレイヤーエネルギー

```java
package com.example.mymod.system.energy;

public final class EnergyState {

    private int energy;

    public int get() {
        return energy;
    }

    public void set(int value) {
        energy = Math.max(0, Math.min(value, EnergySystem.MAX_ENERGY));
    }

    public void add(int delta) {
        set(energy + delta);
    }
}
```

* Minecraft API に依存しない
* テスト可能
* 純粋なデータ構造

## 7. ステップ③：計算ロジックを書く

### 7.1 役割

* 数値変換
* 判定
* シミュレーション

### 7.2 例

```java
package com.example.mymod.system.energy;

public final class EnergyCalculator {

    public static int consume(int current, int cost) {
        return Math.max(0, current - cost);
    }

    public static int generate(int current, int amount) {
        return Math.min(EnergySystem.MAX_ENERGY, current + amount);
    }
}
```

**Minecraft を一切知らないコード**であることが理想。

## 8. ステップ④：イベントと接続する

ここで初めて DSL と接続する。

### 8.1 Event DSL から呼ぶ

```java
package com.example.mymod.logic.events;

import com.example.mymod.system.energy.*;
import com.yourname.yourmod.api.event.PlayerJoinEvent;
import com.yourname.yourmod.api.libs.internal.EventBuilder;

public final class EnergyEvents {

    public static void register() {

        new EventBuilder<>(PlayerJoinEvent.class)
            .handle(event -> {
                EnergyState state = EnergyApi.get(event.getPlayer());
                state.set(100);
            });
    }
}
```

**イベントは「入口」**
ロジックは system 側にある。

## 9. ステップ⑤：Client 表示と接続する

### 9.1 HUD 例

```java
package com.example.mymod.client;

import com.example.mymod.system.energy.EnergyApi;
import com.yourname.yourmod.api.client.Client;

public final class EnergyClient {

    public static void init() {

        Client.init(client -> {

            client.hud()
                .overlay((graphics, delta) -> {
                    int energy = EnergyApi.getClientEnergy();
                    graphics.drawString("Energy: " + energy, 10, 10);
                });

            client.registerAll();
        });
    }
}
```

## 10. システム API を必ず用意する

### 理由

* Event / Client / Block / Item から直接内部実装に触らせない
* 後で内部構造を壊せる

### 例

```java
package com.example.mymod.system.energy;

import net.minecraft.world.entity.player.Player;

public final class EnergyApi {

    public static EnergyState get(Player player) {
        // Capability / Map / Data など
        return null;
    }

    public static int getClientEnergy() {
        return 0;
    }
}
```

## 11. やってはいけない設計

❌ BlockBuilder の中で計算
❌ Event DSL の中で状態を直接持つ
❌ Client から system 内部クラスを直接触る
❌ DataGen でロジックを書く

---
(ここから下はMDK作者のメモ)
## 12. 最後に：今後 DSL を増やすときの指針

新 DSL を作る前に必ず考えること：

1. これは「登録」か？
2. ロジックを隠せているか？
3. 実行タイミングは明確か？
4. Server / Client は分離されているか？

この4つがうまく組み合わさるのであればDSLとしての設計は大丈夫。
