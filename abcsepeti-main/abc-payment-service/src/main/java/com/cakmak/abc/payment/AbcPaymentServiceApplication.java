package com.cakmak.abc.payment;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Halil Cakmak, Date : 25-Jul-2020
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cakmak.abc"})
@EnableFeignClients(basePackages = {"com.cakmak.abc"})
@EnableDiscoveryClient
public class AbcPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcPaymentServiceApplication.class, args);
		Stripe.apiKey = "sk_test_51HyGx6G9R9y827ntfKTizO243LzKHnaNIucO8i7apU0zuTIE5iNAes6l64aoWczGwiCnnBNsvvrgS95nfpbWa2cw00FnScmrhd";
	}

}

