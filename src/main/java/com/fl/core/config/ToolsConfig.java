package com.fl.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
@EnableAspectJAutoProxy
public class ToolsConfig {
    
    @Bean
    @Description("Call monitoring aspect that monitors call count and call invocation time")
    public CallMonitoringAspect callMonitor() {
        return new CallMonitoringAspect();
    }
}
