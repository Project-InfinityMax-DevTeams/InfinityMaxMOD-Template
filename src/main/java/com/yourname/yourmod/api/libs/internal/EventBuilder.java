package com.yourname.yourmod.api.libs.internal;

import com.yourname.yourmod.api.event.*;
import java.util.function.Consumer;

/**
 * fluent蠖｢蠑上〒繧､繝吶Φ繝郁ｨｭ螳壹ｒ陦後≧DSL
 */
public final class EventBuilder<T extends ModEvent> {

    private final Class<T> eventClass;

    private EventPriority priority = EventPriority.NORMAL;
    private boolean async = false;

    public EventBuilder(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    /**
     * 蜆ｪ蜈亥ｺｦ險ｭ螳・
     */
    public EventBuilder<T> priority(EventPriority priority) {
        this.priority = priority;
        return this;
    }

    /**
     * 髱槫酔譛溷ｮ溯｡・
     */
    public EventBuilder<T> async() {
        this.async = true;
        return this;
    }

    /**
     * 蜷梧悄螳溯｡鯉ｼ域・遉ｺ・・
     */
    public EventBuilder<T> sync() {
        this.async = false;
        return this;
    }

    /**
     * 繧､繝吶Φ繝亥・逅・匳骭ｲ・域怙邨ら｢ｺ螳夲ｼ・
     */
    public void handle(Consumer<T> consumer) {
        ModEventBus.listen(eventClass, consumer, priority, async);
    }
}
