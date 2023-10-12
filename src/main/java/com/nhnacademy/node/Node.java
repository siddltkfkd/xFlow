package com.nhnacademy.node;

public class Node extends Thread {
    static int count = 0;
    long interver = 1000;

    public Node() {
        setName(getClass().getSimpleName() + "-" + Integer.valueOf(count++));
    }

    public Node(String name) {
        setName(name);
    }

    public void preprocess() {

    }

    public void process() {
        System.out.println(getName());
    }

    public void postprocess() {

    }

    public void interver() {
        try {
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
