package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyConnectedException;
import com.nhnacademy.exception.OutofPortCountException;
import com.nhnacademy.message.Message;
import com.nhnacademy.port.Port;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputNode extends Node {
    Port[] peerports;
    int portCount;

    public InputNode(int portCount) {
        super();
        peerports = new Port[portCount];
        log.info("input node created {}", getName());
    }

    public InputNode(String name, int portCount) {
        super(name);
        peerports = new Port[portCount];
        log.info("input node created {}", getName());
    }

    public void connect(int index, Port port) {
        if (index > portCount) {
            throw new OutofPortCountException();
        }

        if (peerports[index] != null) {
            throw new AlreadyConnectedException();
        }

        peerports[index] = port;
        log.info("{} connected {}", getName(), index);
    }

    public void output(Message message) {
        boolean accept = true;

        for (Port port : peerports) {
            accept = accept && port.getMessageQueue().isEmpty();
        }
        log.info("output ready");
        if (accept) {
            for (Port port : peerports) {
                port.put(message);
                log.info("message put : {}", message);
            }
        }
    }

}
