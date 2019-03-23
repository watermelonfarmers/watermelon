package com.watermelonfarmers.watermelon.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/api/users/**").permitAll()
                .antMatchers("/api/requirements/**").permitAll()
                .antMatchers("/api/messages/**").permitAll()
                .antMatchers("/api/issues/**").permitAll()
                .antMatchers("/hello").permitAll()
                .antMatchers("/h2console/**").permitAll()
                .antMatchers("/api/logout").permitAll()
                .anyRequest().authenticated().and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
                .logoutSuccessUrl("/logout.done").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true).and()
                .csrf().disable().cors();
    }


    @Override
    public void configure(WebSecurity webSecurity) throws Exception {

        webSecurity.ignoring()
                .antMatchers("/h2console/**");

    }
}