package com.nhnacademy.node;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Node extends Thread {
    static int count = 0;
    long interver = 1000;

    public Node() {
        setName(getClass().getSimpleName() + "-" + Integer.valueOf(count++));
        log.trace("node created {}", getName());
    }

    public Node(String name) {
        setName(name);
        log.trace("node created {}", getName());
    }

    public void preprocess() {
        log.trace("{} : preprocess", getName());
    }

    public void process() {
        log.trace("{} : process", getName());
    }

    public void postprocess() {
        log.trace("{} : postprocess", getName());
    }

    public void interver() {
        try {
            log.trace("{} : sleep", getName());
            Thread.sleep(interver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        preprocess();

        while (!Thread.currentThread().isInterrupted()) {
            process();
            interver();
        }

        postprocess();
    }
}
