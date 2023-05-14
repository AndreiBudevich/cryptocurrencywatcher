package com.cryptocurrencywatcher.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(
        title = "REST API documentation", version = "1.0",
        description = "Java Enterprise Cryptocurrency Watcher",
        contact = @Contact(url = "https://github.com/AndreiBudevich/cryptocurrencywatcher", name = "Andrei Budevich", email = "budevichac01@gmail.com")))
public class OpenApiConfig {
}
