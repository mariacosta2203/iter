package com.generation.iter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig {

	 @Autowired
	    private JwtAuthFilter authFilter;

	    @Bean
	    UserDetailsService userDetailsService() {

	        return new UserDetailsServiceImpl();
	    }

	    @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }

	    @Bean
	    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

	    @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    	http
		        .sessionManagement(management -> management
		                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		        		.csrf(csrf -> csrf.disable())
		        		.cors(withDefaults());

	    	http
		        .authorizeHttpRequests((auth) -> auth
		                .requestMatchers("/usuarios/logar").permitAll()
		                .requestMatchers("/usuarios/cadastrar").permitAll()
		                .requestMatchers("/error/**").permitAll()
		                .requestMatchers(HttpMethod.OPTIONS).permitAll()
		                .anyRequest().authenticated())
		        .authenticationProvider(authenticationProvider())
		        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
		        .httpBasic(withDefaults());

			return http.build();

	    }
}
