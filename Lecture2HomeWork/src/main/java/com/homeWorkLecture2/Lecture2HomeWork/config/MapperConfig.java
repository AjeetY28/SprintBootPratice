package com.homeWorkLecture2.Lecture2HomeWork.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {
    @Bean
   public ModelMapper getModelMapper()
   {
       return new ModelMapper();
   }
}
