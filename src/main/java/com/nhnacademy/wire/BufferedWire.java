package com.nhnacademy.wire;

import java.util.LinkedList;
import java.util.Queue;
import com.nhnacademy.message.Message;

public class BufferedWire implements Wire {
    
    Queue<Message> messageQueue;

    public BufferedWire() {
        super();
        messageQueue = new LinkedList<>();
    }

    public void put(Message message) {
        messageQueue.add(message);
    }

    public Message look() {
        return messageQueue.peek();
    }

    public Message get() { 
        return messageQueue.poll();
    }

    public boolean hasMessage() {
        return !messageQueue.isEmpty();
    }

}
