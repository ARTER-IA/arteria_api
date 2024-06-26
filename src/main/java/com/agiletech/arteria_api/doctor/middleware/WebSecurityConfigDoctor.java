package com.agiletech.arteria_api.doctor.middleware;

import com.agiletech.arteria_api.doctor.domain.service.DoctorService;
import com.agiletech.arteria_api.security.middleware.JwtAuthenticationEntryPointUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfigDoctor extends WebSecurityConfigurerAdapter {

    @Autowired
    DoctorService doctorService;

    @Autowired
    JwtAuthenticationEntryPointUser unauthorizedHandler;

    @Bean
    public JwtAuthorizationFilterDoctor authorizationFilterDoctor() {
        return new JwtAuthorizationFilterDoctor();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(doctorService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/v1/doctors/auth/**","/api/v1/doctors","/api/v1/doctors/**","/swagger-ui/**", "/v2/api-docs/**", "/swagger-resources/**", "/configuration/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authorizationFilterDoctor(), UsernamePasswordAuthenticationFilter.class);

    }

}
