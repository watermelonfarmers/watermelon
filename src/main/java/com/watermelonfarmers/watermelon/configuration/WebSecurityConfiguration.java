//package com.watermelonfarmers.watermelon.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.httpBasic().and()
//                .authorizeRequests()
//                .antMatchers("/api/users/**").permitAll()
//                .antMatchers("/api/requirements/**").permitAll()
//
//                .antMatchers("/hello").permitAll()
//                .antMatchers("/h2console/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//
//    @Override
//    public void configure(WebSecurity webSecurity) throws Exception {
//
//        webSecurity.ignoring()
//                .antMatchers("/h2console/**");
//
//    }
//}