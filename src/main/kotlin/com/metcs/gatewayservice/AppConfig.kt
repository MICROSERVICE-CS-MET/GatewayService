package com.metcs.gatewayservice


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class AppConfig {
    @Bean
    fun template(): RestTemplate? {
        return RestTemplate()
    }
}