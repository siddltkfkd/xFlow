package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyConnectedException;
import com.nhnacademy.exception.OutofWireCountException;
import com.nhnacademy.message.Message;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputNode extends Node {       //데이터를 주기만 하는 노드
    Wire[] outputWires;
    int wireCount;

    public InputNode(int wireCount) {
        super();
        outputWires = new Wire[wireCount];
        log.info("input node created {}", getName());
    }

    public InputNode(String name, int wireCount) {
        super(name);
        outputWires = new Wire[wireCount];
        log.info("input node created {}", getName());
    }

    public void connect(int index, Wire wire) {
        if (index > wireCount) {
            throw new OutofWireCountException();
        }

        if (outputWires[index] != null) {
            throw new AlreadyConnectedException();
        }

        outputWires[index] = wire;
        log.info("{} connected {}", getName(), index);
    }

    public void putMessage(Message message) {
        boolean accept = true;

        for (Wire wire : outputWires) {
            accept = accept && wire.getMessageQueue().isEmpty();
        }
        log.info("output ready : {}", getName());
        if (accept) {
            for (Wire wire : outputWires) {
                wire.put(message);
                log.info("message put : {}", message);
            }
        }
        log.info("output success");
    }

}
