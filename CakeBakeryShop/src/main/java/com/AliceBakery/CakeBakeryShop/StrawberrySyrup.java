package com.AliceBakery.CakeBakeryShop;

import org.springframework.stereotype.Component;

@Component
public class StrawberrySyrup implements Syrup{

    public String getSyrupType()
    {
        return "Strawberry Syrup";
    }
}
