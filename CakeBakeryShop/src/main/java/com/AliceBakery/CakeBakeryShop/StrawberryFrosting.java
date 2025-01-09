package com.AliceBakery.CakeBakeryShop;

import org.springframework.stereotype.Component;

@Component
public class StrawberryFrosting implements Frosting{
    public String getFrostingType()
    {
        return "Strawberry Frosting";
    }

}
