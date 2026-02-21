package com.yuyuto.infinitymaxapi.gamelibs.energy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EnergyNetwork {

    //登録ノード一覧
    private final Set<EnergyNode> nodes = new HashSet<>();
    //接続情報(片方向グラフ)
    private final Map<EnergyNode, Set<EnergyNode>> connections = new HashMap<>();
    //転送ルール
    private final TransferStrategy transferStrategy;

    public EnergyNetwork(TransferStrategy strategy){
        this.transferStrategy = strategy;
    }
    //ノード登録
    public void addNode(EnergyNode node){
        nodes.add(node);
        connections.putIfAbsent(node, new HashSet<>());
    }
    //接続作成
    public void connect(EnergyNode from,EnergyNode to){
        connections.get(from).add(to);
    }
    //1tick更新
    public void tick(EnergyNetwork network,double deltaTime){
        //Node更新
        for (EnergyNode node : nodes){
            node.onTick(network, deltaTime);
        }
        //転送処理
        for (EnergyNode from : connections.keySet()){
            for (EnergyNode to : connections.get(from)){
                transferStrategy.transfer(from,to,deltaTime);
            }
        }
    }
}
