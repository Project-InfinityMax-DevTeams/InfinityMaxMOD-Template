package com.yourname.yourmod.api.system.state;

/**
 * 型安全な状態識別子。
 * インスタンス同一性で識別する。
 */
public final class StateKey<T> {

    private final Class<T> type;

    private StateKey(Class<T> type) {
        this.type = type;
    }

    public static <T> StateKey<T> create(Class<T> type) {
        return new StateKey<>(type);
    }

    public Class<T> type() {
        return type;
    }
}