/**
 * 
 */
package com.revature.myrev.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author Dipanjali Ghosh
 *
 */
public class JwtAuthEntryPoint implements AuthenticationEntryPoint, Serializable {
	
	/**
	 * 	serialVersionUID needed when implementing Serializable
	 */
	private static final long serialVersionUID = 7105659421115232518L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
