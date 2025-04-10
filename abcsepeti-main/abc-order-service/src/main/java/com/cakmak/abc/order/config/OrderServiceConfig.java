package com.cakmak.abc.order.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Halil Cakmak,
 * Date : 2019-07-01
 */
@Configuration
public class OrderServiceConfig {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
