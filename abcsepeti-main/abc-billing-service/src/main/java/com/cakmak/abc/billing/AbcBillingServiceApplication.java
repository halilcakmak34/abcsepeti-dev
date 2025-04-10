package com.cakmak.abc.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cakmak.abc"})
@EnableFeignClients(basePackages = {"com.cakmak.abc"})
@EnableDiscoveryClient
public class AbcBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcBillingServiceApplication.class, args);
	}

}

