package com.lab7sorawit.lab7_673380064_8_sec1.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy {

    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.80;
    }

    @Override
    public String getDiscountName() {
        return "ส่วนลดเทศกาล 20%";
    }
}