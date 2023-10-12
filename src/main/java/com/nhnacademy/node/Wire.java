package com.nhnacademy.node;

import java.util.LinkedList;
import java.util.Queue;

public class Wire{
    

    static int count;
    String id;

    Queue<Message> messageQueue;

    public Wire(){
        messageQueue = new LinkedList<>();
    }

    public void put(Message message){
        messageQueue.add(message);
    }

    public Message get(){
        return messageQueue.poll();
    }








    
}
