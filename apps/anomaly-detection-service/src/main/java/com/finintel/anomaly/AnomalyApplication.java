package com.finintel.anomaly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Application entry point. Business use cases are added behind explicit ports and adapters. */
@SpringBootApplication
public class AnomalyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnomalyApplication.class, args);
    }
}
