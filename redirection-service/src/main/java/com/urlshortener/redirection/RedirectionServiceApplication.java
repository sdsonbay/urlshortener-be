package com.urlshortener.redirection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.urlshortener.redirection")
@EnableJpaRepositories("com.urlshortener.redirection")
@EntityScan(basePackages = "com.urlshortener.redirection")
@Configuration
public class RedirectionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedirectionServiceApplication.class, args);
    }
}