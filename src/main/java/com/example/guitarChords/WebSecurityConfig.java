package com.example.guitarChords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.guitarChords.web.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl uDS;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().disable();
/*
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/chordlist")
			.permitAll()
			.and()
		.logout()
			.permitAll();
*/	
	}	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(uDS).passwordEncoder(new BCryptPasswordEncoder());
    	}

}

