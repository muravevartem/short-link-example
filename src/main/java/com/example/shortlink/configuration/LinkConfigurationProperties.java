package com.example.shortlink.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "short-link")
public class LinkConfigurationProperties {
    private String baseUrl;
}
