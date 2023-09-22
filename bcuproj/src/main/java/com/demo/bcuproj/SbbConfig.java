package com.demo.bcuproj;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SbbConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}