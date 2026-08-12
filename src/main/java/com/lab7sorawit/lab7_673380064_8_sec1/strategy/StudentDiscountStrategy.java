package com.lab7sorawit.lab7_673380064_8_sec1.strategy;

public class StudentDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.90;
    }

    @Override
    public String getDiscountName() {
        return "ส่วนลดนักศึกษา 10%";
    }
}