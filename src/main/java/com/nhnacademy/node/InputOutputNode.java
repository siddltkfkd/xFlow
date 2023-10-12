package com.nhnacademy.node;

import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputOutputNode extends Node {
    Wire[] inputWires;
    Wire[] outputWires;

    InputOutputNode(String name, int inCount, int outCount) {
        super(name);

        inputWires = new Wire[inCount];
        outputWires = new Wire[outCount];
        log.info("in out node created : {}", getName());
    }

    InputOutputNode(int inCount, int outCount) {
        super();

        inputWires = new Wire[inCount];
        outputWires = new Wire[outCount];
        log.info("in out node created : {}", getName());
    }

    public Wire getOutputWire(int index) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return outputWires[index];
    }

    public void connectOutputWire(int index, Wire wire) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        outputWires[index] = wire;
        log.info("{} connect {}", getName(), index);
    }

    public int getInputWireCount() {
        return inputWires.length;
    }

    public Wire getInputWire(int index) {
        if (index < 0 || inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return inputWires[index];
    }

    void output(Message message) {
        log.trace("Message Out ready");
        for (Wire wire : outputWires) {
            if (wire != null) {
                wire.put(message);
                log.trace("out message : {}", message);
            }
        }
        log.trace("Message Out success");
    }
}
