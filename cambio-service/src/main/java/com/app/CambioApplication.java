package com.app;

import com.app.api_key.ApiKeyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CambioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CambioApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {

        FilterRegistrationBean<ApiKeyFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiKeyFilter());

        registrationBean.addUrlPatterns("/cambio-service/insert");
        return registrationBean;
    }
}