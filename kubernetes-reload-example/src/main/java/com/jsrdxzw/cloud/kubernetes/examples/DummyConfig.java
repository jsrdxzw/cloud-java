package com.jsrdxzw.cloud.kubernetes.examples;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuzhiwei
 * @date 2022/8/5 17:15
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "dummy")
public class DummyConfig {
    private String message = "this is a dummy message";

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
