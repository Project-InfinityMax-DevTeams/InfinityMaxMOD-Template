package com.yuyuto.infinitymaxapi.gamelibs.energy;

public class Energy {
    private double resistance; //抵抗値
    private double voltage; //電圧
    private double amphea; //電流
    private double joule; //電力消費・発電量

    public void update(double datetime){
        //オームの法則 V=RI
        voltage = resistance * amphea;
        //電力 P=VI
        double power = voltage * amphea;
        //発熱量 J=PS
        joule += power * datetime;
    }
    public void setResistance(double resistance){
        this.resistance = resistance;
    }
    public void setAmphea(double amphea){
        this.amphea = amphea;
    }
    public double getVoltage(){
        return voltage;
    }
    public double getJoule(){
        return joule;
    }
}
