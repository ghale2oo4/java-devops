package com.example.devops_java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Value("${spring.application.name:unknown}")
    private String applicationName;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {

        return ResponseEntity.ok(
                Map.of(
                        "status", "UP",
                        "application", applicationName,
                        "timestamp", Instant.now().toString()
                )
        );
    }
}