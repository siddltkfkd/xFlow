package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TerminalNode extends InputOutputNode {
    
    Socket socket;
    String clientAddr;

    public TerminalNode(int inCount,int outCount, Socket socket) throws SocketException {
        super(inCount, outCount);
        this.socket = socket;
        clientAddr = socket.getLocalAddress().getHostAddress();  // 클라이언트 주소
    }

    public void setSoket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void preprocess() {
        log.info("{} : socket 받기 성공");
        log.info("접속 클라이언트 주소 : {}", clientAddr);
    }

    @Override
    public void process() {
        try{
            //try - resource에 생성한 것과
            //아래와 같이 생성한 것 차이
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request;
            request = reader.readLine(); 
            Message message = new StringMessage(request);
            outputWires[0].put(message);
            
            String response = "HTTP/1.1 200 OK\r\n\r\n123\r\n";
            //response = get();
            writer.write(response);
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} : {}", getClass().getSimpleName(), e.getCause());
        } 
    }

    @Override
    public void postprocess() {
        // TODO Auto-generated method stub
        super.postprocess();
    }


}
