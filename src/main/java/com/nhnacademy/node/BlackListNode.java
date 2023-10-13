package com.nhnacademy.node;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackListNode extends ServerNode {

    Socket clientSocket;
    List<String> blackList = new LinkedList<>();

    String clientAddress = clientSocket.getInetAddress().getHostAddress();

    @Override
    public void process() {
        block(clientSocket);
    }

    public BlackListNode(int inCount, int outCount, Socket clientsocket) {
        super(inCount, outCount);
        this.clientSocket = clientsocket;
    }

    public void block(Socket socket) {
        log.info("클라이언트의 IP : {} ", clientAddress);
        for (String black : blackList) {
            if (black == clientAddress) {
                log.info("해당 IP주소는 접근제한 되었습니다.");
                log.info("제한된 주소 : {}", clientAddress);

            }
        }

    }

}
