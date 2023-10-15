package com.nhnacademy;

import java.net.ServerSocket;
import java.net.Socket;
import com.nhnacademy.node.EMSNode;
import com.nhnacademy.node.PredicateNode;
import com.nhnacademy.node.TerminalNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpTcpServer {
    
    public static void main(String[] args) {
        
        int port = 1234;

        //thread 생성 및 start
        TerminalNode terminalNode;
        PredicateNode predicateNode = new PredicateNode(1, 2);      //inCount 0 : TerminalNode outputWire   , outCount 0 : ParseNode inpoutWire , outCount 1 : SelectNode inputWire
        EMSNode emsNode = new EMSNode(1, 2);

        //emsNode.start();

        //connet

        //HttpTcpServer 클래스 구조를 다시 개선해야할듯.
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket socket;
            
            while((socket = serverSocket.accept()) != null) {
                log.info("{} Socket 연결 성공", Thread.currentThread().getClass().getSimpleName());

                terminalNode = new TerminalNode(1, 1, socket);
                terminalNode.connect(0, predicateNode.getWire(0));      // p의 intputWire 0번에 있는 Wire를 t의 비어있는 outputWire의 0번에 있는 곳에 연결
                terminalNode.start();
            }

            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
