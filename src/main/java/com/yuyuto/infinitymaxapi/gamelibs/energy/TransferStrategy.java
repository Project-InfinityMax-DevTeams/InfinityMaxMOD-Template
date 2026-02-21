package com.yuyuto.infinitymaxapi.gamelibs.energy;

public interface TransferStrategy {
    void transfer(EnergyNode from,EnergyNode to,double deltaTime);
}
