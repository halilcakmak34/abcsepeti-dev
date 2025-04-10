package com.cakmak.abc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Halil Cakmak,
 * Date : 2019-13-06
 */
@SpringBootApplication(scanBasePackages = {"com.cakmak.abc.commons"})
@ComponentScan(basePackages = {"com.cakmak.abc"})
//, excludeFilters={
//		@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=GlobalSecurityConfig.class)})
@EnableFeignClients(value = "com.cakmak.abc")
@EnableEurekaClient
public class AbcOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbcOrderServiceApplication.class, args);
    }

}
