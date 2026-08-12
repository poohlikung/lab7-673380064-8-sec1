package com.lab7sorawit.lab7_673380064_8_sec1.strategy;

public interface DiscountStrategy {
    double calculateFinalPrice(double price);

    String getDiscountName();
}
