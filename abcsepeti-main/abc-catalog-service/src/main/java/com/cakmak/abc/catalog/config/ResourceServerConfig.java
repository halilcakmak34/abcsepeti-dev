package com.cakmak.abc.catalog.config;

import com.cakmak.abc.commons.security.GlobalResourceServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
public class ResourceServerConfig extends GlobalResourceServerConfig {
    
    @Autowired
    private ResourceServerTokenServices tokenServices;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("web").tokenServices(tokenServices);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/actuator/**", "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs/**", "/v3/api-docs/**", "/api-docs/**","/swagger-ui/**", "/h2-console/**", "/signin", "/authorize", "/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
                .antMatchers(HttpMethod.GET, "/product**/**").permitAll()
                .antMatchers(HttpMethod.GET, "/review/**").permitAll()
                .antMatchers(HttpMethod.GET, "/image/**").permitAll()
                .antMatchers("/**").authenticated();
    }
}
