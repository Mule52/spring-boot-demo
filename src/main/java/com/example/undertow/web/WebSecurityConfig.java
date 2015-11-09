package com.example.undertow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Add CSRF token to header
        http.addFilterAfter(new CsrfTokenGeneratorFilter(), CsrfFilter.class);

        // Permit files in the webapp root that are not in js/styles directories.
        // Permit directories in webapp.
        http
            .authorizeRequests()
            .antMatchers(
                "/favicon.ico",
                "/config.js",
                "/aurelia-bootstrapper",
                "/dist/**",
                "/jspm_packages/**",
                "/styles/**"
            )
            .permitAll();

        http
            .authorizeRequests()
//                .antMatchers("/", "/home", "/actor/**", "/api/csrf").permitAll()
                .antMatchers("/", "/home", "/api/**").permitAll()  // should we expose all api end points?
                .antMatchers("/logout","/login").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home")
                .permitAll();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(
                "select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery(
                "select username, role from user_roles where username=?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}