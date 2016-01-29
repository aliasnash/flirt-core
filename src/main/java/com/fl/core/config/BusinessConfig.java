package com.fl.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

@Configuration
@ComponentScan(basePackages = "com.fl.core")
@Import({ HibernateConfig.class })
@PropertySources({ @PropertySource(value = "classpath:core${dev-number:}.properties", ignoreResourceNotFound = false) })
public class BusinessConfig {
    
    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }
}
