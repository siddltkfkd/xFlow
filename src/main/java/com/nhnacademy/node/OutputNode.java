package com.nhnacademy.node;

import com.nhnacademy.exception.OutofWireCountException;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutputNode extends Node {      //데이터를 받기만 하는 노드
    Wire[] intputWire;
    int wireCount;

    public OutputNode(int wireCount) {
        super();
        intputWire = new Wire[wireCount];
        log.info("output node created : {}", getName());
    }

    public OutputNode(String name, int wireCount) {
        super(name);
        intputWire = new Wire[wireCount];
        for (int i = 0; i < wireCount; i++) {
            intputWire[i] = new Wire();
        }
        log.info("output node created : {}", getName());
    }

    // 와이어 가져오기
    public Wire getWire(int index) {
        if (wireCount < index) {
            throw new OutofWireCountException();
        }
        return intputWire[index];
    }

}
