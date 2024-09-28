package com.app;

import com.app.api_key.ApiKeyFilter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "API desenvolvida para testes do OpenApi"))
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {

		FilterRegistrationBean<ApiKeyFilter> registrationBean =
				new FilterRegistrationBean<>();

		registrationBean.setFilter(new ApiKeyFilter());

		registrationBean.addUrlPatterns("/book-service/insert");
		return registrationBean;
	}
}
