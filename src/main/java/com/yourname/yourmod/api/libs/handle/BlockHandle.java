package com.yourname.yourmod.api.libs.handle;

public final class BlockHandle {

    private final Object raw;

    public BlockHandle(Object raw) {
        this.raw = raw;
    }

    public Object raw() {
        return raw;
    }
}
