package com.lab7sorawit.lab7_673380064_8_sec1.strategy;

import org.springframework.stereotype.Component;

@Component
public class DiscountContext {

    public DiscountStrategy getStrategy(String discountType) {
        if ("STUDENT".equalsIgnoreCase(discountType)) {
            return new StudentDiscountStrategy();
        }

        if ("SEASONAL".equalsIgnoreCase(discountType)) {
            return new SeasonalSaleStrategy();
        }

        return new NoDiscountStrategy();
    }
}