package com.metcs.gatewayservice.security

import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import java.util.function.Predicate

@Component
class RouteValidator {
    val openApiEndpoints = listOf(
        "/users/register",
        "/users/login"
    )
    var isSecured: Predicate<ServerHttpRequest> = Predicate<ServerHttpRequest> { request ->
        openApiEndpoints
            .stream()
            .noneMatch { uri: String ->
                request.getURI().getPath().contains(uri)
            }
    }
}