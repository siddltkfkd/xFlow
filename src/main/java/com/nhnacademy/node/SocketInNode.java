package com.nhnacademy.node;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketInNode extends OutputNode {

    public SocketInNode(int wireCount) {
        super(wireCount);
        setName(getClass().getSimpleName());
        log.info("SocketInNode created {}", getName());
    }
    

}
