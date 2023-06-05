package com.einuvy.inmueble.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;
    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;
    @Value("${service.security.secure-key-username2}")
    private String SECURE_KEY_USERNAME2;
    @Value("${service.security.secure-key-password2}")
    private String SECURE_KEY_PASSWORD2;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
          AuthenticationManagerBuilder.class
        );

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities(AuthorityUtils.createAuthorityList("ADMIN"))
                .and()
                .withUser(SECURE_KEY_USERNAME2)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD2))
                .authorities(AuthorityUtils.createAuthorityList("DEV"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());
         return http
                 .antMatcher("/**").authorizeRequests()
                 .anyRequest().hasAnyAuthority("ADMIN")
                 .and().csrf().disable()
                 .httpBasic()
                 .and().build();
         /*.and()
                 .exceptionHandling()
                 .accessDeniedHandler(((request, response, accessDeniedException) -> {
                     response.sendRedirect("https://google.com");
                 }))*/
    };

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
