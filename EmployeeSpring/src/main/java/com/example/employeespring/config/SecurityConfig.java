package com.example.employeespring.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("ALL")
@Deprecated(forRemoval = true)
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private JwtAuthentication jwtAuthentication;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityConfig(JwtAuthentication jwtAuthentication, AuthenticationProvider authenticationProvider) {
        this.jwtAuthentication = jwtAuthentication;
        this.authenticationProvider = authenticationProvider;
    }

    //    @Bean
//    public SecurityFilterChain securityFilterChain1(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//
//        return  httpSecurity.build();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                .disable();
//        httpSecurity
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        httpSecurity
//                .authorizeRequests()
//                .requestMatchers("/api/auth/register")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//
//        httpSecurity
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class);
//
//        return httpSecurity.build();
//    }
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .requestMatchers("/api/auht/", "/employee")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(
//                        (request, response, ex) -> {
//                            response.sendError(
//                                    HttpServletResponse.SC_UNAUTHORIZED,
//                                    ex.getMessage()
//                            );
//                        }
//                );
////        http.addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .requestMatchers("/api/auht/**", "/employee/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class)
                http.exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                );
        return http.build();
    }
}

//                .requestMatchers("/api/auth/demoController/welcome") 35


//.anyRequest()
//        .authenticated()
//        .and()