package com.eudycontreras.othello.models;

import java.util.LinkedList;

public class MinMaxNode {
    GameBoardState state;
    LinkedList<MinMaxNode> children = new LinkedList<>();
    MinMaxNode parent;
    int alphaValue = Integer.MIN_VALUE;
    int betaValue = Integer.MAX_VALUE;
    boolean isRoot = false;
    int value;
    boolean isMax;


    public MinMaxNode(int value){
        this.value = value;
    }

    public MinMaxNode(GameBoardState state){
        this.state = state;
        isRoot = true;
        isMax = true;
        this.value = state.getBlackCount();
    }

    public MinMaxNode(GameBoardState state, MinMaxNode parent){
        this.state = state;
        this.parent = parent;
        parent.addChild(this);
        this.isMax = !parent.isMax;

    }

    private void addChild(MinMaxNode minMaxNode) {
        children.add(minMaxNode);
    }

    public int getValue() {
        return value;
    }

    public GameBoardState getState() {
        return state;
    }

    public boolean getIsMax() {
        return isMax;
    }

    public void setAlpha(int alpha) {
        this.alphaValue = alpha;
    }

    public void setBeta(int betaValue) {
        this.betaValue = betaValue;
    }

    public LinkedList<MinMaxNode> getChildren() {
        return children;
    }

    public int getAlphaValue() {
        return alphaValue;
    }

    public int getBetaValue() {
        return betaValue;
    }
}
