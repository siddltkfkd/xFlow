package com.nhnacademy.port;

import java.util.LinkedList;
import java.util.Queue;

import com.nhnacademy.exception.PortIsEmptyException;
import com.nhnacademy.exception.PortIsFullException;
import com.nhnacademy.message.Message;

public class Port {
    Queue<Message> messageQueue;
    int size;

    public Port() {
        this.messageQueue = new LinkedList<>();
        this.size = 4;
    }

    public Port(int size) {
        this.messageQueue = new LinkedList<>();
        this.size = size;
    }

    public void put(Message message) {
        if (messageQueue.size() < size) {
            messageQueue.add(message);
        } else {
            throw new PortIsFullException();
        }
    }

    public void get() {
        // 가져오면서 큐에서 삭제
        if (messageQueue.isEmpty()) {
            throw new PortIsEmptyException();
        } else {
            messageQueue.poll();
        }
    }

    public void peek() {
        // 삭제하지않고 값만 가져옴
        if (messageQueue.isEmpty()) {
            throw new PortIsEmptyException();
        } else {
            messageQueue.peek();
        }
    }

    public Queue<Message> getMessageQueue() {
        return messageQueue;
    }

}
