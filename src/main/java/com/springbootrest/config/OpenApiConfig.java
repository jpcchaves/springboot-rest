package com.springbootrest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI().info(
        new Info().title("RESTful API").version("v1")
            .description("Rest API built with Spring Framework")
            .termsOfService("https://porfolio-jpcchaves.vercel.app/")
            .license(new License().name("MIT").url("https://porfolio-jpcchaves.vercel.app/")));
  }

}
