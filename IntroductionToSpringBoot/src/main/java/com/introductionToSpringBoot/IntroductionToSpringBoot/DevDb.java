package com.introductionToSpringBoot.IntroductionToSpringBoot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DevDb implements DB{
    public String getData()
    {
        return "Dev Data";
    }
}
