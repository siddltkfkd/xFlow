package com.nhnacademy.node;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EMSNode extends InputOutputNode {

    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;

    public EMSNode(int inCount, int outCount) {
        super(inCount, outCount);
        //TODO Auto-generated constructor stub
    }    

    @Override
    public void preprocess() {
        try {
            socket = new Socket("ems.nhnacademy.com", 1880);
            log.info("{} : socket연결 성공", getClass().getSimpleName());
        } catch (IOException e) {
            log.error("{} : socket 연결 실패", getClass().getName());
            e.printStackTrace();
        }
    }

    @Override
    public void process() {
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            
            String request;

            request = "GET /dev/24e124128c067999 HTTP/1.1\r\n\r\n";
            writer.write(request);
            writer.flush();

            String response;
            while((response=reader.readLine())!=null) {
                System.out.println(response);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void postprocess() {
        try {
            socket.close();
        } catch (IOException e) {
            log.error("{} : socket 닫기 실패", getClass().getSimpleName());
        }
    }

}
