package com.butterchicken.UberAssistant.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.butterchicken.UberAssistant.controller", "com.butterchicken.UberAssistant.repo", "com.butterchicken.UberAssistant.entity", "com.butterchicken.UberAssistant.service", "com.butterchicken.UberAssistant.service.impl", "com.butterchicken.UberAssistant.config"})
public class AppConfig {
}
