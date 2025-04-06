package com.btg.orderservice.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Order Service API",
                version = "1.0",
                description = "API para gerenciamento de pedidos de usuários",
                contact = @Contact(name = "Ramon Silva", email = "ramonsilva12305@outlook.com")
        ))
public class SwaggerConfig {
    }
