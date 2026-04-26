package com.example.SpringBoot_web.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapperconfig {
    @Bean
    public ModelMapper getModelmapper(){
       return new ModelMapper();
    }
}
