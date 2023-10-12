package com.nhnacademy.message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Message {
    static int count;
    final String id;
    long creationTime;

    Message() {
        count++;
        id = getClass().getSimpleName() + count;
        creationTime = System.currentTimeMillis();
        log.trace("message created : {}", id);
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
