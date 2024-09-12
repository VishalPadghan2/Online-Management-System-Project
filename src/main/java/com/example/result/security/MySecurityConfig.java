package com.example.result.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;

@Controller 
public class MySecurityConfig {
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		        .csrf().disable()
		        .authorizeHttpRequests()
		        .requestMatchers("/assets/**", "/public/**").permitAll()
		        .requestMatchers("/admin/**").hasRole("ADMIN")
		        .anyRequest()
		        .authenticated()
		        .and()
		        .formLogin()
		        // .loginPage("customLoginPage.html)
		        // .usernameParameter("customHtmlNameValueForUsername")
		        // .passwordParameter("customHtmlNameValueForPassword")
		        // .loginProcessingUrl("/login")
		        .defaultSuccessUrl("/admin/students/", true)
		        .and()
		        .logout().invalidateHttpSession(true).clearAuthentication(true)
		        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        .logoutSuccessUrl("/public/").permitAll()
		        .and()
		        .rememberMe().rememberMeParameter("remember_me").key("mySecreteKey").tokenValiditySeconds(0);
		 return http.build();
	}
	@Bean
	protected UserDetailsService userDetailsService() {
		List<UserDetails> listUser = new ArrayList<>();
				listUser.add(
						User.builder()
						.username("admin")
						.password(getPasswordEncoder().encode("123"))
						.roles("ADMIN")
						.build()
			);
		return new InMemoryUserDetailsManager(listUser);
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// TODO Auto-generated method stub
		return NoOpPasswordEncoder.getInstance();
	}

}
