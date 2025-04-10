package com.cakmak.abc.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.cakmak.abc")
@EnableFeignClients(basePackages = "com.cakmak.abc")
public class AbcCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcCatalogServiceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
	}
}
