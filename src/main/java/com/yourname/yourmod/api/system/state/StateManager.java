package com.yourname.yourmod.api.system.state;

public interface StateManager {

    StateContainer attach(StateOwner owner);

    StateContainer getOrCreate(StateOwner owner);

    void detach(StateOwner owner);
}