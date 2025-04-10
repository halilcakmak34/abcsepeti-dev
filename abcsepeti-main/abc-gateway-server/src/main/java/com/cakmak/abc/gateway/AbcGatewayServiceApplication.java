package com.cakmak.abc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: Halil Cakmak,
 * Date : 2019-05-14
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class AbcGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcGatewayServiceApplication.class, args);
	}

}
