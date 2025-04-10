//package com.cakmak.abc.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Collections;
//
//@Configuration
//public class GlobalCorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        source.registerCorsConfiguration("/**", config);
//        config.setAllowCredentials(false);
//        config.setAllowedHeaders(Collections.singletonList("*"));
//        config.setAllowedMethods(Collections.singletonList("*"));
//        config.setExposedHeaders(Collections.singletonList("*"));
//        config.setAllowedOriginPatterns(Collections.singletonList("*"));
//        return new CorsFilter(source);
//    }
//}
