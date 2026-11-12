# Implementation plan

## Phase 0 - Foundation (scaffolded)
- [x] Multi-module Maven structure
- [x] Shared domain and event contract starter
- [x] Local PostgreSQL, Redis and Kafka compose environment
- [x] CI verification workflow
- [ ] Run CI and fix any dependency/build issues

## Phase 1 - Durable ingestion
- [ ] Transaction API request/response contracts
- [ ] Authentication and tenant authorization
- [ ] PostgreSQL schema and Flyway migrations
- [ ] Idempotency key storage and unique constraints
- [ ] Transaction + outbox atomic write
- [ ] Outbox publisher and retry/backoff
- [ ] Integration tests with Testcontainers

## Phase 2 - Event streaming
- [ ] Kafka topic and partition design
- [ ] Schema registry and compatibility policy
- [ ] Consumer groups, retries and DLQ
- [ ] Inbox/deduplication strategy
- [ ] Replay tooling and operational runbooks

## Phase 3 - Intelligence
- [ ] Flink job lifecycle and checkpointing
- [ ] Event-time windows and late-event handling
- [ ] Explainable anomaly rules
- [ ] Reconciliation matching and discrepancy workflow
- [ ] Notification delivery tracking

## Phase 4 - Lakehouse and analytics
- [ ] Object storage and Iceberg catalog
- [ ] Bronze/Silver/Gold ingestion
- [ ] Spark transformations and backfills
- [ ] Trino query layer and analytics marts
- [ ] Data quality, lineage and freshness checks

## Phase 5 - Production readiness
- [ ] OIDC, RBAC, tenant isolation and secret management
- [ ] Threat model and security testing
- [ ] Load, stress, soak and chaos testing
- [ ] SLOs, dashboards and actionable alerts
- [ ] Backup restore and disaster recovery exercises
- [ ] Kubernetes/Terraform production environments
- [ ] Cost, capacity and operational review
