package com.algaworks.festa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//Password erro:
//https://www.harinathk.com/spring/no-passwordencoder-mapped-id-null/
@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
		.inMemoryAuthentication()
		.withUser("joao").password("123").roles("USER")
		.and()
		.withUser("alexandre").password("123").roles("USER")
		.and()
		.withUser("thiago").password("123").roles("USER");
		
		
		//User.withDefaultPasswordEncoder().username("joao").password("123").roles("USER").build(); 
		
		
	}
	
	//Erro password null
	//https://www.harinathk.com/spring/no-passwordencoder-mapped-id-null/
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
