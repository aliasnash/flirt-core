package com.fl.core.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Import({ BusinessConfig.class, ToolsConfig.class })
public class RootApplicationContextConfig {
    
    @PostConstruct
    public void init() {
        log.info("###RootApplicationContextConfig loaded!###");
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
