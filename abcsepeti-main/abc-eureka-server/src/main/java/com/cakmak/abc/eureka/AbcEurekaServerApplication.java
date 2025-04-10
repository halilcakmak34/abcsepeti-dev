package com.cakmak.abc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Halil Cakmak,
 * Date : 2019-05-14
 */
@SpringBootApplication
@EnableEurekaServer
public class AbcEurekaServerApplication {



	public static void main(String[] args) {
		SpringApplication.run(AbcEurekaServerApplication.class, args);
	}

}
