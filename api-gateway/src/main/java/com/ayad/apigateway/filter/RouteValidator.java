package com.ayad.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static List<String> openApiEndpoints = List.of(
            "/api/auth/register",
            "/api/auth/authenticate"
    );

    public Predicate<ServerHttpRequest> isSecure =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().equals(uri));
}
