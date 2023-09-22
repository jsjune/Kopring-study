package com.example.userservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JWTConfiguration {
    @Bean
    fun jwtProperties(): JWTProperties = JWTProperties()
}
