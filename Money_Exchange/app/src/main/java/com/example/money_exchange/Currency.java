package com.example.money_exchange;

import java.io.Serializable;

public class Currency implements Serializable {
    private String name;
    private String code;
    private double price;

    public Currency(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name;
    }
}
