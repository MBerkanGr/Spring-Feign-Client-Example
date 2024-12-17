package com.mehmetberkan.springfeignclientexample.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    private static final String JWT_TOKEN = "exampleexample";

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + JWT_TOKEN);

            System.out.println("URL : " + requestTemplate.url());
            System.out.println("Method : " + requestTemplate.method());
        };
    }
}
