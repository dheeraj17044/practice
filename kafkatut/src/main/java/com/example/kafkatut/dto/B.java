package com.example.kafkatut.dto;

import java.io.Serializable;

public class B implements Serializable {

    private String type;
    private int c;
    private int d;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "B{" +
                "type='" + type + '\'' +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
