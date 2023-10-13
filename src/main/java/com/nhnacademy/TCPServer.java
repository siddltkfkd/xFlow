package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.nhnacademy.node.InputOutputNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TCPServer extends InputOutputNode {
    
    int port;
    ServerSocket serverSocket;

    public TCPServer(int port) {
        super(2,2);
        this.port = port;
    }

    @Override
    public void preprocess() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            log.info("TCPServer ServerSocket 생성 실패");
        }

    }

    @Override
    public void process() {
        try {
            Socket socket = serverSocket.accept();




        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void postprocess() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
