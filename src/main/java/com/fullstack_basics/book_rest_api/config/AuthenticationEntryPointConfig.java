package com.fullstack_basics.book_rest_api.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

// import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPointConfig extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		JSONObject jsonObject = new JSONObject();

		response.addHeader("WWW-Authenticate", "Basic Realm - " + getRealmName());
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		
		try {
			writer.println(jsonObject.put("Exception", "HTTP Status 401 - " + authException.getMessage()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("almightyjava");
		super.afterPropertiesSet();
	}
}
