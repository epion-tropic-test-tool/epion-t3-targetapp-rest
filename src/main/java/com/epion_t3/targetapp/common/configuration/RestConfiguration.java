package com.epion_t3.targetapp.common.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate restTemplate() {

        RestTemplateBuilder builder = new RestTemplateBuilder();

        return builder.build();
    }
}