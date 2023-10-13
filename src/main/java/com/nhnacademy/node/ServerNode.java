package com.nhnacademy.node;

public abstract class ServerNode extends InputOutputNode {

    public ServerNode(String name, int inCount, int outCount) {
        super(name, 2, 1);
    }

    public ServerNode(int inCount, int outCount) {
        super(2, 1);
    }

}
