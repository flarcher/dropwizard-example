package com.company.example.http;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

public class CORS_ResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(
			ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		// https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS/Errors/CORSMissingAllowOrigin
		// WARNING! This is not a good practice for security
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
	}
}
