package com.example.shortlink.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LinkConfigurationProperties.class)
public class LinkConfiguration {
}
