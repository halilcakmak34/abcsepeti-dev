package com.cakmak.abc.account;

import com.cakmak.abc.commons.security.GlobalResourceServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author: Halil Cakmak, Date : 2019-05-16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cakmak.abc"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = GlobalResourceServerConfig.class)})
@EnableFeignClients
@EnableDiscoveryClient
public class AbcAccountServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AbcAccountServiceApplication.class, args);
  }

}
