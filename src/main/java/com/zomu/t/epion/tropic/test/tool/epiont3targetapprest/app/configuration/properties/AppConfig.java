package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.zomu.t.epion")
@Data
public class AppConfig {

    private String stubUrl;

}
