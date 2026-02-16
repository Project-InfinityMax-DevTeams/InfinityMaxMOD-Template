package com.yourname.yourmod.api.system.state;

public interface StateOwner {
    UUID uuid();
    StateScope scope();
}