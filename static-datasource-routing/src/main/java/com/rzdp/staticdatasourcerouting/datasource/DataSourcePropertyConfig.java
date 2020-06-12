package com.rzdp.staticdatasourcerouting.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "datasource")
@Data
public class DataSourcePropertyConfig {

    private DataSourceProperty bangkok;
    private DataSourceProperty hongkong;

    @Data
    public static class DataSourceProperty {
        private String url;
        private String password;
        private String username;
    }
}
