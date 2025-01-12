package com.SpringCore.springcoredemo.config;

import com.SpringCore.springcoredemo.common.Coach;
import com.SpringCore.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
