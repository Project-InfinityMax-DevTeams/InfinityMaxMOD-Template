package com.yuyuto.infinitymaxapi.gamelibs.energy;

public interface EnergyNode {
    Energy getEnergy();

    void onTick(EnergyNetwork network, double deltaTime);
}
