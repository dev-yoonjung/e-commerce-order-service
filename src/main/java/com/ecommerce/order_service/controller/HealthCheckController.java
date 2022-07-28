package com.ecommerce.order_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/order-service")
@RestController
public class HealthCheckController {

    private final Environment environment;

    @GetMapping("/health-check")
    public String status() {
        return String.format(
                "It's working in order service on port %s",
                environment.getProperty("local.server.port"));
    }

}
