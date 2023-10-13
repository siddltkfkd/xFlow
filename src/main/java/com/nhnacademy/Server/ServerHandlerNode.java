package com.nhnacademy.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.nhnacademy.node.InputOutputNode;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ServerHandlerNode extends InputOutputNode {
    public ServerHandlerNode(int inCount, int outCount) {
        super(inCount, outCount);
        // TODO Auto-generated constructor stub
    }

    int port = 12345;

    @Override
    public void run() {
        preprocess();
        process();
        postprocess();
    }

    @Override
    public void process() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
                Socket socket = serverSocket.accept();
                ServerNode echo = new ServerNode(socket);
                echo.start();   
        } catch (IOException e) {
            log.info("Thread exception");
        }
    }


    public static void main(String[] args) {
        
        ServerHandlerNode handlerNode = new ServerHandlerNode(2,2);

        handlerNode.start();
    }

}
