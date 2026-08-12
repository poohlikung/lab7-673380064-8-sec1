package com.lab7sorawit.lab7_673380064_8_sec1.strategy;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateFinalPrice(double price) {
        return price;
    }

    @Override
    public String getDiscountName() {
        return "ราคาปกติ";
    }
}