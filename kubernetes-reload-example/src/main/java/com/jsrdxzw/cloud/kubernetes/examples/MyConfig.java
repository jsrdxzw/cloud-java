package com.jsrdxzw.cloud.kubernetes.examples;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuzhiwei
 * @date 2022/8/5 17:09
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "bean")
public class MyConfig {
    private String message = "a message that can be changed live";

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
