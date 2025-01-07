package com.introductionToSpringBoot.IntroductionToSpringBoot;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class Apple {
    void eatApple()
    {

        System.out.println("I am eating the apple");
    }

    @PostConstruct
    void callThisBeforeUsed()
    {
        System.out.println("creating the apple ");
    }

    @PreDestroy
    void callThisBeforeDestroy()
    {
        System.out.println("Destory the bean");
    }

}
