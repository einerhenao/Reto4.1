/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.ControllerSecurityOAuth2;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
 @Override
 protected void configure(HttpSecurity http) throws Exception {
 http.authorizeRequests(a -> a.antMatchers("/", "/url/**", "/error",
 "/webjars/**", "/Reservation/**", "/client/**", "/Cabin/**",
 "/Category/**", "/Admin/**", "/Score/**", "/Message/**", "/api/**").permitAll()
 .anyRequest().authenticated()
 ).exceptionHandling(e -> e
 .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
 ).oauth2Login();
 http.cors().and().csrf().disable();
 }
}

