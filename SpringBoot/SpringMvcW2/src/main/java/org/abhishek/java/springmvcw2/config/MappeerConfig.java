package org.abhishek.java.springmvcw2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappeerConfig {


    @Bean
    public ModelMapper modelMapper() {
           return new ModelMapper();
    }
}
