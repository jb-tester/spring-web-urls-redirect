package com.mytests.spring.springweburlscompletion;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * *
 * <p>Created by irina on 6/21/2022.</p>
 * <p>Project: spring-web-urls-completion</p>
 * *
 */

@ConfigurationProperties()
public record MyConfPropsRecord(String fooProp1, String fooProp2) {
}
