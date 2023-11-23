package com.eudycontreras.othello.models;

import java.util.LinkedList;

public class MinMaxNode {
    GameBoardState state;
    LinkedList<MinMaxNode> children;
    MinMaxNode parent;
    int alphaValue = Integer.MIN_VALUE;
    int betaValue = Integer.MAX_VALUE;
    boolean isRoot = false;
    int value;
    boolean isMax;


    public MinMaxNode(GameBoardState state){
        this.state = state;
        isRoot = true;
        isMax = true;

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

    public void setValue() {
        this.value = state.getBlackCount();
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

    public LinkedList<MinMaxNode> getChildren() {
        return children;
    }
}
