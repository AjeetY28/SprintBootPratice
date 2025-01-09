package com.introductionToSpringBoot.IntroductionToSpringBoot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    // field Injection @Autowired
    private DB db;

    //constructor Injection
    public DbService(DB db)
    {
        this.db=db;
    }
    String getData()
    {
        return db.getData();
    }
}
