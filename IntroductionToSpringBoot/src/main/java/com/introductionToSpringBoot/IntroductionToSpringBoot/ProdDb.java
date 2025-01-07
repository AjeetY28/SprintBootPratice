package com.introductionToSpringBoot.IntroductionToSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class ProdDb implements DB{
    public String getData()
    {
        return "Production Data";
    }
}
