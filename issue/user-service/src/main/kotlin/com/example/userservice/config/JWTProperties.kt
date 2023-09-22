package com.example.userservice.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JWTProperties {
    lateinit var issuer: String
    lateinit var subject: String
    var expiresTime: Long = 0
    lateinit var secret: String
}


