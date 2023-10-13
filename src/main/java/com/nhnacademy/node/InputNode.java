package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyConnectedException;
import com.nhnacademy.exception.OutofWireCountException;
import com.nhnacademy.message.Message;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputNode extends Node {
    Wire[] inputWires;
    int wireCount;

    public InputNode(int wireCount) {
        super();
        inputWires = new Wire[wireCount];
        log.info("input node created {}", getName());
    }

    public InputNode(String name, int wireCount) {
        super(name);
        inputWires = new Wire[wireCount];
        log.info("input node created {}", getName());
    }

    public void connect(int index, Wire wire) {
        if (index > wireCount) {
            throw new OutofWireCountException();
        }

        if (inputWires[index] != null) {
            throw new AlreadyConnectedException();
        }

        inputWires[index] = wire;
        log.info("{} connected {}", getName(), index);
    }

    public void putMessage(Message message) {
        boolean accept = true;

        for (Wire wire : inputWires) {
            accept = accept && wire.getMessageQueue().isEmpty();
        }
        log.info("output ready : {}", getName());
        if (accept) {
            for (Wire wire : inputWires) {
                wire.put(message);
                log.info("message put : {}", message);
            }
        }
        log.info("output success");
    }

    public void putMessage(int index, Message message) {
        log.info("message input ready : {}", getName());
        inputWires[index].put(message);
        log.info("{} put message : {}", getName(), message.toString());
    }

}
