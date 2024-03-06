package com.davr7.mspayroll.feignclients.config;

import com.davr7.mspayroll.feignclients.decoder.EmployeeErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean
    public Encoder encoder() {
        return new FormEncoder();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new EmployeeErrorDecoder();
    }

    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}


