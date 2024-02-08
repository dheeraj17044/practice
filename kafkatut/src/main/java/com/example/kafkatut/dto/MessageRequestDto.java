package com.example.kafkatut.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MessageRequestDto implements Serializable {

    private String type;

//    @JsonProperty("number")
    private int number;

    //    @JsonProperty("message")
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRequestDto{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", message='" + message + '\'' +
                '}';
    }
}
