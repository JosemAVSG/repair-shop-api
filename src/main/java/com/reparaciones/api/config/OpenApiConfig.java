package com.reparaciones.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Sistema de Reparaciones")
                        .version("1.0.0")
                        .description("API REST para sistema de gestión de reparaciones de dispositivos electrónicos y línea blanca")
                        .contact(new Contact()
                                .name("Soporte")
                                .email("soporte@reparaciones.com"))
                        .license(new License()
                                .name("Licencia Proprietaria")
                                .url("https://reparaciones.com/licencia")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor de Desarrollo")
                ));
    }
}