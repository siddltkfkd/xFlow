package com.nhnacademy.Server;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ServerNode {
    
    Socket clientSocket;
    List<String> blackList = new LinkedList<>();

    public ServerNode(Socket clientsocket){
        this.clientSocket = clientsocket;
    }

    String clientAddress = clientSocket.getInetAddress().getHostAddress();
    
    public void block(Socket socket){
        log.info("클라이언트의 ip 주소는 : {} 입니다.", clientAddress);
        for (String p : blackList){
            if( p == clientAddress){
                log.info("해당 주소는 접근이 제한되었습니다.");
                log.info("제한된 주소 : {}", clientAddress);
                
                try {
                    socket.close();    
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
            }
        }
        
    }


    
}
