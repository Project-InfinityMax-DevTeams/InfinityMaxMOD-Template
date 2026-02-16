package com.yourname.yourmod.api.system.state;

public interface StateManager {

    StateContainer attach(StateOwner owner);

    StateContainer getOrCreate(StateOwner owner);

    void detach(StateOwner owner);
}

public final class DefaultStateManager implements StateManager {

    private final Map<StateOwner, StateContainer> containers =
            Collections.synchronizedMap(new WeakHashMap<>());

    @Override
    public StateContainer attach(StateOwner owner) {
        StateContainer container = new StateContainer();
        containers.put(owner, container);
        return container;
    }

    @Override
    public StateContainer getOrCreate(StateOwner owner) {
        return containers.computeIfAbsent(owner, o -> new StateContainer());
    }

    @Override
    public void detach(StateOwner owner) {
        containers.remove(owner);
    }
}