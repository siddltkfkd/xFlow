package com.nhnacademy.Server;

import java.net.ServerSocket;
import java.net.Socket;
import com.nhnacademy.node.InputOutputNode;

public class ServerHandlerNode extends InputOutputNode {
    public ServerHandlerNode(int inCount, int outCount) {
        super(inCount, outCount);
        // TODO Auto-generated constructor stub
    }

    int port = 12345;

    @Override
    public void process() {
        super.process();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();

                
                ServerNode echo = new ServerNode(socket);
                echo.start();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }



}
