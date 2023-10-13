package com.nhnacademy.Server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import com.nhnacademy.node.InputOutputNode;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ServerNode extends InputOutputNode {

    Socket clientSocket;
    List<String> blackList = new LinkedList<>();
    String clientAddress = "";
    

    public ServerNode(Socket clientsocket) {
        super(2, 2);
        this.clientSocket = clientsocket;
        clientAddress = clientSocket.getInetAddress().getHostAddress();
    }

    
    @Override
    public void preprocess() {
        super.preprocess();
        block(clientSocket);
    }

    public void block(Socket socket) {
        
        log.info("클라이언트의 ip 주소는 : {} 입니다.", clientAddress);
        for (String p : blackList) {
            if (p == clientAddress) {
                log.info("해당 주소는 접근이 제한되었습니다.");
                log.info("제한된 주소 : {}", clientAddress);

                try {
                    socket.close();
                    log.info("접속 종료");
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }

    public void process() {
        blackList.add("local");

        try (Socket socket = new Socket(clientAddress, clientSocket.getLocalPort())) {

           BufferedReader terminalIn = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader socketIn =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter socketOut =
                    new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            while (!Thread.currentThread().isInterrupted()) {
                String line = socketIn.readLine() + "\n";
                socketOut.write(line + "\n");
                socketOut.flush();
            }

        } catch (Exception e) {
            log.info("message exception");
            // TODO: handle exception
        }



    }


}
