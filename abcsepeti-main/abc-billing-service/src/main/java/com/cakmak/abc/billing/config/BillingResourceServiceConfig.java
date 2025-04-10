package com.cakmak.abc.billing.config;

import com.cakmak.abc.commons.security.GlobalResourceServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @author: Halil Cakmak,
 * Date : 2019-09-20
 */
@Configuration
public class BillingResourceServiceConfig extends GlobalResourceServerConfig {
    
    @Autowired
    private ResourceServerTokenServices tokenServices;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("web").tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**", "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs/**", "/v3/api-docs/**", "/api-docs/**","/swagger-ui/**", "/h2-console/**", "/signin", "/authorize", "/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
                .antMatchers("/**").authenticated();
    }
    
}
