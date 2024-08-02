package com.nhnacademy.message;

public class StringMessage extends Message {

    String stringValue;

    public StringMessage(String message) {
        stringValue = message;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
