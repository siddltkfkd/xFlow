package com.nhnacademy.node;

import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;

public class PredicateNode extends InputOutputNode {

    Message fromTerminalNode;

    public PredicateNode(int inCount, int outCount) {
        super(inCount, outCount);
    }

    @Override
    public void preprocess() {

    }

    @Override
    public void process() {
        //while(!inputWires[0].getMessageQueue().isEmpty()) {
            fromTerminalNode = inputWires[0].get();
        //}
            System.out.println(fromTerminalNode);
        if(fromTerminalNode instanceof StringMessage) {
            System.out.println("------"+fromTerminalNode.toString());   
        }
    }

    @Override
    public void postprocess() {
        
    }
    

}
