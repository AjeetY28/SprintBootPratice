package com.AliceBakery.CakeBakeryShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting,Syrup syrup)
    {
        this.frosting=frosting;
        this.syrup=syrup;
    }

    public String bakeCalled() {
        return (frosting.getFrostingType()+" "+syrup.getSyrupType());
    }
}
