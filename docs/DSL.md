# DSL Reference

## Purpose
This document explains the DSL classes in the current MDK structure.
All code snippets are aligned with current API signatures.

## 1. Registry DSL
Entry point:
- `com.yuyuto.infinitymaxapi.api.libs.Registry`

Available methods:
- `Registry.block(String id)` -> `BlockBuilder`
- `Registry.item(String id)` -> `ItemBuilder`
- `Registry.entity(String id, Supplier<T> factory)` -> `EntityBuilder<T>`
- `Registry.blockEntity(String id, Supplier<T> factory)` -> `BlockEntityBuilder<T>`

BlockBuilder
Syntax:
```java
Registry.block(id)
    .template(Object)
    .strength(float)
    .noOcclusion()
    .build()
```
 Element          | Required | Description             | Default Value             
 ----------- | -- | -------------- | -------------------   
 id          | Required | Block registration ID       | Compilation error             
 template    | Optional | Base block object            | new Object() is created            
 strength    | Optional | Block hardness             | Default value used             
 noOcclusion | Optional | Setting to allow light pass-through       | false               

Short Template:
```java
BlockHandle block = Registry.block(“sample_block”)
        .template(new Object())
        .strength(3.0f)
        .noOcclusion()
        .build();
```

### ItemBuilder
Syntax:
```java
Registry.item(id)
        .template(Object)
        .stack(int)
        .tab(Object)
        .durability(int)
        .build()

```
| Element         | Required | Description                 | If not specified             |
| ---------- | -- | ------------------ | ------------------- |
| id         | Required | Item registration ID           | Cannot be built               |
| template   | Optional | Specifies the template for the item           | new Object() is generated     |
| stack      | Optional | Specifies the item's stack limit     | Default value 64 is used     |
| tab        | Optional | Specifies the Creative tab or category  | null (does not belong to any tab)   |
| durability | Optional | Specifies durability             | Default value 0 is used     |

Short template:
```java
Object item = Registry.item(“sample_item”)
        .template(new Object())
        .stack(64)
        .tab(“misc_tab”)
        .durability(120)
        .build();
```

#### EntityBuilder
Syntax:
```java
Registry.entity(id, Supplier<T>)
        .category(Object)
        .size(float width, float height)
        .build()
```

| Element          | Required | Description                               | Default Value    |
| ----------- | -- | -------------------------------- | ---------- |
| id          | Required | Entity registration ID                       | Cannot be built      |
| Supplier<T> | Required | Entity instance generation factory              | Cannot be built      |
| category    | Optional | Entity category (creature, monster, etc.) | null       |
| width       | Optional | Entity width                         | Default 0.6f |
| height      | Optional | Entity height                        | Default 1.8f |

Short template:
```java
Object entity = Registry.entity(“sample_entity”, Object::new)
        .category(“creature”)
        .size(0.8f, 1.6f)
        .build();
```

### BlockEntityBuilder
Methods:
- `blocks(Object... blocks)`
- `build()` -> `T`

Short template:
```java
Object blockEntity = Registry.blockEntity("sample_be", Object::new)
        .blocks(block)
        .build();
```

## 2. Event DSL
Entry point:
- `com.yuyuto.infinitymaxapi.api.libs.Events`

Available methods:
- `Events.on(Class<T>)`
- `Events.playerJoin()`

Builder methods:
- `priority(EventPriority)`
- `async()`
- `sync()`
- `handle(Consumer<T>)`

Short template:
```java
Events.playerJoin()
        .priority(EventPriority.NORMAL)
        .handle(event -> {
            Object player = event.player;
            System.out.println("joined: " + player);
        });
```

## 3. Client DSL
Entry point:
- `com.yuyuto.infinitymaxapi.api.libs.Client`

Builder objects:
- `renders()` -> `RenderDSL`
- `keybinds()` -> `KeybindDSL`
- `screens()` -> `ScreenDSL`
- `hud()` -> `HudDSL`

Each sub-DSL currently exposes:
- `registerAll()`

Short template:
```java
Client.init(client -> {
    client.renders().registerAll();
    client.keybinds().registerAll();
    client.screens().registerAll();
    client.hud().registerAll();
});
```

Note:
- `Client.init(...)` already calls `builder.registerAll()` internally.

## 4. Datagen DSL
Entry point:
- `com.yuyuto.infinitymaxapi.api.libs.datagen.DataGen`

Available methods:
- `DataGen.block(String)` -> `BlockGen`
- `DataGen.item(String)` -> `ItemGen`
- `DataGen.entity(String)` -> `EntityGen`

Common finalize method:
- `end()`

Short template:
```java
DataGen.block("sample_block").end();
DataGen.item("sample_item").lang("Sample Item").end();
DataGen.entity("sample_entity").lang("Sample Entity").end();
```

## 5. Packet DSL
Entry point:
- `com.yuyuto.infinitymaxapi.api.libs.packet.Packet`

Core methods:
- `Packet.define(String id)`
- `serverbound()` / `clientbound()`
- `codec(...)`
- `handle(...)`
- `register()`
- `sendToServer(T)`
- `sendToPlayer(Object, T)`

Short template:
```java
Packet<String> ping = Packet.<String>define("ping")
        .serverbound()
        .codec(buf -> "ping", (packet, buf) -> {})
        .handle((packet, ctx) -> System.out.println(packet));

ping.register();
ping.sendToServer("hello");
```

## 6. Common event helper
`CommonEvents.onPlayerJoin(Object player)` posts `PlayerJoinEvent` to `ModEventBus`.
Use this path for shared event behavior.

---

# DSL リファレンス

## 目的
このドキュメントは、現行MDK構成のDSLクラスを説明します。
すべてのサンプルコードは現在のAPIシグネチャに合わせています。

## 1. Registry DSL
インポート入口:
- `com.yuyuto.infinitymaxapi.api.libs.Registry`

利用可能メソッド:
- `Registry.block(String id)` -> `BlockBuilder`
- `Registry.item(String id)` -> `ItemBuilder`
- `Registry.entity(String id, Supplier<T> factory)` -> `EntityBuilder<T>`
- `Registry.blockEntity(String id, Supplier<T> factory)` -> `BlockEntityBuilder<T>`

### BlockBuilder
構文:
```java
Registry.block(id)
    .template(Object)
    .strength(float)
    .noOcclusion()
    .build();
```
 要素          | 必須 | 説明             | 指定しない場合             
 ----------- | -- | -------------- | ------------------- 
 id          | 必須 | ブロック登録ID       | コンパイル不可             
 template    | 任意 | 元となるブロックオブジェクト | new Object() が生成される 
 strength    | 任意 | ブロックの硬さ        | デフォルト値使用            
 noOcclusion | 任意 | 光を遮らない設定       | false               

ショートテンプレ:
```java
Object block = Registry.block("sample_block")
        .template(new Object())
        .strength(3.0f)
        .noOcclusion()
        .build();
```

### ItemBuilder
構文:
```java
Registry.item(id)
        .template(Object)
        .stack(int)
        .tab(Object)
        .durability(int)
        .build();

```
| 要素         | 必須 | 説明                 | 指定しない場合             |
| ---------- | -- | ------------------ | ------------------- |
| id         | 必須 | アイテム登録ID           | ビルド不可               |
| template   | 任意 | アイテムの元となるテンプレートを指定 | new Object() が生成される |
| stack      | 任意 | アイテムのスタック上限を指定     | デフォルト値 64 が使用される    |
| tab        | 任意 | クリエイティブタブやカテゴリを指定  | null（どのタブにも所属しない）   |
| durability | 任意 | 耐久値を指定             | デフォルト値 0 が使用される     |

ショートテンプレ:
```java
Object item = Registry.item("sample_item")
        .template(new Object())
        .stack(64)
        .tab("misc_tab")
        .durability(120)
        .build();
```

### EntityBuilder

構文:

```java
Registry.entity(id, Supplier<T>)
        .category(Object)
        .size(float width, float height)
        .build();
```

| 要素          | 必須 | 説明                               | 指定しない場合    |
| ----------- | -- | -------------------------------- | ---------- |
| id          | 必須 | エンティティ登録ID                       | ビルド不可      |
| Supplier<T> | 必須 | エンティティインスタンス生成ファクトリ              | ビルド不可      |
| category    | 任意 | エンティティカテゴリ（creature, monster など） | null       |
| width       | 任意 | エンティティの幅                         | デフォルト 0.6f |
| height      | 任意 | エンティティの高さ                        | デフォルト 1.8f |

ショートテンプレ:
```java
Object entity = Registry.entity("sample_entity", Object::new)
        .category("creature")
        .size(0.8f, 1.6f)
        .build();
```

### BlockEntityBuilder
構文:
```java
Registry.blockEntity(id,Supplier<T>)
        .blocks(object...)
        .build();
```
| 要素          | 必須 | 説明                   | 指定しない場合    |
| ----------- | -- | -------------------- | ---------- |
| id          | 必須 | ブロックエンティティ登録ID       | ビルド不可      |
| Supplier<T> | 必須 | ブロックエンティティ生成ファクトリ    | ビルド不可      |
| blocks      | 任意 | このブロックエンティティに紐づくブロック | 空配列（紐付けなし） |

ショートテンプレ:
```java
Object blockEntity = Registry.blockEntity("sample_be", Object::new)
        .blocks(block)
        .build();
```

## 2. Event DSL
入口:
- `com.yuyuto.infinitymaxapi.api.libs.Events`

構文:
```java
Events.on(Class<T>)
      .priority(EventPriority)
      .async() / .sync()
      .handle(Consumer<T>)
```
| 要素               | 必須 | 説明           | 指定しない場合   |
| ---------------- | -- | ------------ | --------- |
| Class<T>         | 必須 | 対象のイベントクラス   | ビルド不可     |
| priority         | 任意 | イベント実行の優先度   | NORMAL    |
| async / sync     | 任意 | 非同期/同期での処理選択 | 同期 (sync) |
| handle(Consumer) | 必須 | イベント受信時の処理   | ビルド不可     |

ショートテンプレ:
```java
Events.playerJoin()
        .priority(EventPriority.NORMAL)
        .handle(event -> {
            Object player = event.player;
            System.out.println("joined: " + player);
        });
```

## 3. Client DSL
入口:
- `com.yuyuto.infinitymaxapi.api.libs.Client`

テンプレ:
```java
Client.init(client -> {
    client.renders().registerAll();
    client.keybinds().registerAll();
    client.screens().registerAll();
    client.hud().registerAll();
});
```

| 要素                   | 必須 | 説明                            | 指定しない場合                |
| -------------------- | -- | ----------------------------- | ---------------------- |
| Client.init(builder) | 必須 | ClientDSL の初期化。ラムダでサブDSLにアクセス | ビルド不可                  |
| renders()            | 任意 | レンダー関連登録                      | 呼ばない場合、レンダー登録なし        |
| keybinds()           | 任意 | キーバインド登録                      | 呼ばない場合、キー登録なし          |
| screens()            | 任意 | GUIスクリーン登録                    | 呼ばない場合、スクリーン登録なし       |
| hud()                | 任意 | HUD表示登録                       | 呼ばない場合、HUD登録なし         |
| registerAll()        | 任意 | まとめてサブDSLを登録                  | 呼ばない場合、各DSLで個別登録する必要あり |

補足:
- `Client.init(...)` 内で `builder.registerAll()` は自動実行されます。

## 4. Datagen DSL
入口:
- `com.yuyuto.infinitymaxapi.api.libs.datagen.DataGen`

構文:
```java
DataGen.block(StringID).end();
DataGen.item(StringID).lang("English Name Here").end();
DataGen.entity(StringID).lang("English Name Here").end();
```

| 要素                | 必須 | 説明                      | 指定しない場合     |
| ----------------- | -- | ----------------------- | ----------- |
| block(String id)  | 必須 | ブロック用データを生成するエントリポイント   | ビルド不可       |
| item(String id)   | 必須 | アイテム用データを生成するエントリポイント   | ビルド不可       |
| entity(String id) | 必須 | エンティティ用データを生成するエントリポイント | ビルド不可       |
| lang(String name) | 任意 | 表示名や言語データを設定            | デフォルト名なし    |
| end()             | 任意 | データ生成の確定処理              | 呼ばないと登録されない |

ショートテンプレ:
```java
DataGen.block("sample_block").end();
DataGen.item("sample_item").lang("Sample Item").end();
DataGen.entity("sample_entity").lang("Sample Entity").end();
```

## 5. Packet DSL
入口:
- `com.yuyuto.infinitymaxapi.api.libs.packet.Packet`

テンプレ:
```java
Packet<String> ping = Packet.<String>define("ping")
        .serverbound()
        .codec(buf -> "ping", (packet, buf) -> {})
        .handle((packet, ctx) -> System.out.println(packet));

ping.register();
ping.sendToServer("hello");
```

| 要素                            | 必須 | 説明                   | 指定しない場合    |
| ----------------------------- | -- | -------------------- | ---------- |
| define(String id)             | 必須 | パケットIDを指定            | ビルド不可      |
| serverbound() / clientbound() | 必須 | パケットの送受信方向を指定        | ビルド不可      |
| codec(decoder, encoder)       | 必須 | パケットのデコード/エンコード方法を指定 | ビルド不可      |
| handle(PacketHandler)         | 任意 | 受信時の処理を指定            | 無処理になる     |
| register()                    | 必須 | パケットを登録              | パケット送受信不可  |
| sendToServer(T)               | 任意 | サーバー送信を行う            | 呼ばなければ送信なし |
| sendToPlayer(Object, T)       | 任意 | 特定プレイヤーに送信           | 呼ばなければ送信なし |

## 6. 共通イベント補助
`CommonEvents.onPlayerJoin(Object player)` は `PlayerJoinEvent` を `ModEventBus` に投稿します。
共通イベント処理はこの経路を使います。
