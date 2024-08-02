package com.nhnacademy;

import com.nhnacademy.message.StringMessage;
import com.nhnacademy.node.InputNode;
import com.nhnacademy.node.InputOutputNode;
import com.nhnacademy.node.OutputNode;

public class Main {
    public static void main(String[] args) {
        InputNode input = new InputNode(1);
        InputOutputNode inout = new InputOutputNode(1, 1);
        OutputNode output = new OutputNode(1);

        input.start();
        inout.start();
        output.start();

        input.connect(0, inout.getWire(0));
        inout.connect(0, output.getWire(0));

        input.putMessage(new StringMessage("hi"));
        inout.putMessage(new StringMessage("hello"));

        inout.getWire(0).peek();
        output.getWire(0).peek();
    }
}