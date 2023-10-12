package com.nhnacademy;

import com.nhnacademy.message.Message;
import com.nhnacademy.node.InputNode;
import com.nhnacademy.node.Node;
import com.nhnacademy.node.OutputNode;

public class Main {
    public static void main(String[] args) {
        // Node node = new Node();
        // node.start();

        InputNode input = new InputNode(1);
        OutputNode output = new OutputNode(1);

        input.start();
        output.start();

        input.connect(0, output.getInputPort(0));
        input.output(new Message("Message"));
    }
}