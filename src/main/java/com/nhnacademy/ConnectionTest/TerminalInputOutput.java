package com.nhnacademy.ConnectionTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.Options;
import com.nhnacademy.node.InputOutputNode;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TerminalInputOutput extends InputOutputNode {

    static List<TerminalInputOutput> serverList = new ArrayList<TerminalInputOutput>();
    BufferedWriter writer;
    ServerSocket serverSocket;
    Socket clientSocket;
    int port;
    Options options = new Options();

    public TerminalInputOutput(int inCount, int outCount, int port) throws IOException {
        super(inCount, outCount);
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }


    public TerminalInputOutput(int inCount, int outCount, Socket socket) {
        super(inCount, outCount);
        serverList.add(this);
        this.clientSocket = socket;
    }

    public TerminalInputOutput(int inCount, int outCount, Socket socket, int port) {
        super(inCount, outCount);
        this.port = port;
        serverList.add(this);
        this.clientSocket = socket;
    }


    
    public void preprocess(){
        log.info("연결 성공!");
    }

    public void process(){



         try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 // 응답을 보내기 위한 출력 스트림
                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)) {

                String request;
                request = input.readLine();
                


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
