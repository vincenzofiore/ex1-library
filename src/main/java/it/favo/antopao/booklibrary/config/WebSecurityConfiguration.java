package it.favo.antopao.booklibrary.config;


import static it.favo.antopao.booklibrary.authentication.SecurityConstants.SIGN_UP_URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import it.favo.antopao.booklibrary.authentication.JWTAuthenticationFilter;
import it.favo.antopao.booklibrary.authentication.JWTAuthorizationFilter;
import it.favo.antopao.booklibrary.services.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Value("${jwt.secret}")
	private String jwtSecret;
	private final UserDetailsServiceImpl userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityConfiguration(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable() //
				.authorizeRequests() //
				.antMatchers(HttpMethod.POST, SIGN_UP_URL) //
				.permitAll() //
				.anyRequest() //
				.authenticated() //
				.and() //
//				.formLogin() //
//				.permitAll() //
//				.and() //
				.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtSecret)) //
				.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtSecret))
				// this disables session creation on Spring Security
				.sessionManagement() //
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v3/api-docs", "/configuration/ui", "/swagger-resources/**", "/swagger-ui/**",
				"/index.html", "/configuration/**", "/webjars/**");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService) //
			.passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
