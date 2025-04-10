package com.cakmak.abc.gateway.config;

import brave.sampler.Sampler;
import com.cakmak.abc.gateway.filters.PostFilter;
import com.cakmak.abc.gateway.filters.PreFilter;
import com.cakmak.abc.gateway.filters.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Halil Cakmak,
 * Date : 2019-05-15
 */
@Configuration
public class ApiGatewayConfig {

    @Bean
    public Sampler sampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
