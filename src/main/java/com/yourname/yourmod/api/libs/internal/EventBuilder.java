package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.event.*;
import java.util.function.Consumer;

/**
 * Event DSL ビルダー
 */
public final class EventBuilder<T extends ModEvent> {

    private final Class<T> eventClass;

    private EventPriority priority = EventPriority.NORMAL;
    private boolean async = false;

    public EventBuilder(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    /** イベント優先度を設定 */
    public EventBuilder<T> priority(EventPriority priority) {
        this.priority = priority;
        return this;
    }

    /** 非同期でイベントを処理 */
    public EventBuilder<T> async() {
        this.async = true;
        return this;
    }

    /** 同期でイベントを処理 */
    public EventBuilder<T> sync() {
        this.async = false;
        return this;
    }

    /** イベントハンドラーを登録 */
    public void handle(Consumer<T> consumer) {
        ModEventBus.listen(eventClass, consumer, priority, async);
    }
}
