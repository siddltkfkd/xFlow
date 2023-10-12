package com.nhnacademy.node;

import com.nhnacademy.exception.OutofPortCountException;
import com.nhnacademy.port.Port;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutputNode extends Node {
    Port[] ports;
    int portCount;

    public OutputNode(int portCount) {
        super();
        ports = new Port[portCount];
        for (int i = 0; i < portCount; i++) {
            ports[i] = new Port();
        }
        log.info("output node created : {}", getName());
    }

    public OutputNode(String name, int portCount) {
        super(name);
        ports = new Port[portCount];
        for (int i = 0; i < portCount; i++) {
            ports[i] = new Port();
        }
        log.info("output node created : {}", getName());
    }

    public Port getInputPort(int index) {
        if (portCount < index) {
            throw new OutofPortCountException();
        }
        return ports[index];
    }

}
