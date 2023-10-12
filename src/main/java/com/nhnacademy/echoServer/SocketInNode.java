package com.nhnacademy.echoServer;


import com.nhnacademy.node.InputNode;
import com.nhnacademy.node.Node;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class SocketInNode extends InputNode{

    public SocketInNode(int wireCount) {
        super(wireCount);
        log.info("Socket input node created {}", getName());
    }


    
    
}
