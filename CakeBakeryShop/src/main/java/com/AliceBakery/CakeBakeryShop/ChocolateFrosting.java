package com.AliceBakery.CakeBakeryShop;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ChocolateFrosting implements Frosting {

    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}
