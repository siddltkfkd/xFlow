package com.nhnacademy.message;

import netscape.javascript.JSObject;

public class Message {
    Object message;
    String type;

    public Message(Object message) {
        this.message = message;
    }

    public void messageType() {
        if (message instanceof String) {
            this.type = "String";
        } else if (message instanceof JSObject) {
            this.type = "JSON";
        }
    }

    @Override
    public String toString() {
        return (String) message;
    }
}
