package com.example.kafkatut.dto;

import java.io.Serializable;

public class A implements Serializable {

    private String type;
    private String a;
    private int b;

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "A{" +
                "type='" + type + '\'' +
                ", a='" + a + '\'' +
                ", b=" + b +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
