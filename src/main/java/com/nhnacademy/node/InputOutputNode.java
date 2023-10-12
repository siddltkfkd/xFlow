package com.nhnacademy.node;

import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.port.Port;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputOutputNode extends Node {
    Port[] inputWires;
    Port[] outputWires;

    InputOutputNode(String name, int inCount, int outCount) {
        super(name);

        inputWires = new Port[inCount];
        outputWires = new Port[outCount];
    }

    InputOutputNode(int inCount, int outCount) {
        super();

        inputWires = new Port[inCount];
        outputWires = new Port[outCount];
    }

    public Port getOutputWire(int index) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return outputWires[index];
    }

    public void connectOutputWire(int index, Port wire) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        outputWires[index] = wire;
    }

    public int getInputWireCount() {
        return inputWires.length;
    }

    public Port getInputWire(int index) {
        if (index < 0 || inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return inputWires[index];
    }

    void output(Message message) {
        log.trace("Message Out");
        for (Port port : outputWires) {
            if (port != null) {
                port.put(message);
            }
        }
    }
}
