# ADR 0001: Platform baseline

- Status: Accepted for initial scaffold
- Date: 2026-11-12

## Context

The project needs a maintainable Java foundation for event-driven financial data processing.

## Decision

Use Java 21 LTS and Maven multi-module structure. Use Spring Boot for service shells, PostgreSQL for operational persistence, Kafka for event distribution, Flink for stream processing and Spark/Iceberg for analytical workloads.

## Consequences

- Shared domain and event contracts are separate Maven modules.
- Services are independently deployable but share a versioned repository build.
- Data processing frameworks are introduced in dedicated modules and must be validated against the chosen JDK and connector versions.
- The baseline is not a production deployment until reliability, security and performance controls are implemented and tested.
