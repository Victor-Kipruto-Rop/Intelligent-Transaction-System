package com.finintel.reconciliation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Application entry point. Business use cases are added behind explicit ports and adapters. */
@SpringBootApplication
public class ReconciliationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReconciliationApplication.class, args);
    }
}
