package com.app.gestiondepedidos;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.Console;
import java.util.Arrays;

@SpringBootApplication
public class GestionDePedidosApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionDePedidosApplication.class, args);

	}
}
