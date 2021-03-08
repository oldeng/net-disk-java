package com.gateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/a/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:9001/hello/a"))
				// .route(r -> r.path("/b/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:9001/hello/b"))
				// .route(r -> r.path("/c/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:9001/hello/c"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
