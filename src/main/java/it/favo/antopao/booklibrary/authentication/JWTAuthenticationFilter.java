package it.favo.antopao.booklibrary.authentication;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static it.favo.antopao.booklibrary.authentication.SecurityConstants.EXPIRATION_TIME;
import static it.favo.antopao.booklibrary.authentication.SecurityConstants.HEADER_STRING;
import static it.favo.antopao.booklibrary.authentication.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.favo.antopao.booklibrary.dto.UserDTO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final String jwtSecret;

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, String jwtSecret) {
		this.authenticationManager = authenticationManager;
		this.jwtSecret = jwtSecret;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
		try {
			UserDTO creds = new ObjectMapper().readValue(req.getInputStream(), UserDTO.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new BadCredentialsException("Unable to get credentials", e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String token = JWT.create() //
				.withSubject(((User) auth.getPrincipal()).getUsername()) //
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //
				.sign(HMAC512(jwtSecret.getBytes()));
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}
}
