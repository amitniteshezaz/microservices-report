package com.example.limitsapigateway;



import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p ->p.path("/get")
				.filters(f->f
						.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("Param","MyValue")
						)
						
				.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**")
				//.route(p->path("/currency-exchange/**")
						.uri("http://localhost:8000/"))
				.route(p->p.path("/currency-conversion/**")
						.uri("http://localhost:8100/"))
				
				.route(p->p.path("/currency-conversion-new/**")
						.filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)","/http://localhost:8100/"))
						.uri("http://localhost:8100/"))
				.build();
	}

}
