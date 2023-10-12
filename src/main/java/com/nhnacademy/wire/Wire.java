package com.nhnacademy.wire;

import java.util.LinkedList;
import java.util.Queue;

import com.nhnacademy.exception.WireIsEmptyException;
import com.nhnacademy.exception.wireIsFullException;
import com.nhnacademy.message.Message;

public class Wire {
    Queue<Message> messageQueue;
    int size;

    public Wire() {
        this.messageQueue = new LinkedList<>();
        this.size = 4;
    }

    public Wire(int size) {
        this.messageQueue = new LinkedList<>();
        this.size = size;
    }

    public void put(Message message) {
        if (messageQueue.size() < size) {
            messageQueue.add(message);
        } else {
            throw new wireIsFullException();
        }
    }

    public Message get() {
        // 가져오면서 큐에서 삭제
        if (messageQueue.isEmpty()) {
            throw new WireIsEmptyException();
        } else {
            return messageQueue.poll();
        }
    }

    public Message peek() {
        // 삭제하지않고 값만 가져옴
        if (messageQueue.isEmpty()) {
            throw new WireIsEmptyException();
        } else {
            return messageQueue.peek();
        }
    }

    public Queue<Message> getMessageQueue() {
        return messageQueue;
    }

}
