package com.reparaciones.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

/**
 * Main application class for the Reparaciones API.
 */
@SpringBootApplication(scanBasePackages = {"com.reparaciones"})
@EntityScan(basePackages = "com.reparaciones.infrastructure.persistence.entity")
@EnableJpaRepositories(basePackages = {
    "com.reparaciones.domain.repository",
    "com.reparaciones.infrastructure.persistence.repository"
})
public class ReparacionesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReparacionesApiApplication.class, args);
    }

}