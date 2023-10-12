package com.nhnacademy.message;

public class Message {
    static int count;
    final String id;
    long creationTime;

    Message() {
        count++;
        id = getClass().getSimpleName() + count;
        creationTime = System.currentTimeMillis();
    }

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }

}
