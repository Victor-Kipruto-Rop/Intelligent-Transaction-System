package com.finintel.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Application entry point. Business use cases are added behind explicit ports and adapters. */
@SpringBootApplication
public class ProcessingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcessingApplication.class, args);
    }
}
