# Intelligent Transaction System

A global-ready, production-oriented Java platform for real-time financial transaction intelligence.

> **Status:** architecture and repository foundation. This is not yet a production payment-processing system. Business workflows, integrations, security controls, deployment and operational evidence must be implemented and verified before real financial data is processed.

## Mission

Build a multi-tenant financial data platform that can evolve from a regional deployment into independently scalable regional cells serving fintechs, payment processors, merchants and financial institutions worldwide.

## Global scalability principles

- Stateless Java services scale horizontally behind regional edge routing.
- Tenant-aware admission control, quotas and noisy-neighbor protection.
- PostgreSQL is authoritative for accepted operational transactions; use atomic outbox and idempotent consumers.
- Kafka distributes events with stable keys and partition-aware consumer scaling.
- Flink handles stateful real-time stream computation; Spark/Iceberg handle historical and batch workloads.
- Each tenant has an authoritative home region for writes; avoid split-brain multi-primary ledger writes.
- Regional recovery, data residency, retention and encryption are explicit architecture concerns.
- Capacity targets are measured through reproducible load, soak, chaos and correctness tests.

Planning envelopes (not guarantees): 1,000 sustained API RPS, 5,000 burst RPS, 10,000 concurrent sessions and millions of events/day. All require cloud-specific benchmark evidence before capacity or SLA claims.

## Technology baseline

- Java 21 LTS, Maven multi-module build, Spring Boot 3.x
- PostgreSQL and Flyway
- Apache Kafka for event distribution
- Apache Flink for stream processing (integration phase)
- Apache Spark, Parquet, Apache Iceberg and Trino for data engineering (integration phase)
- Redis for cache and ephemeral coordination
- Docker Compose for local development
- Kubernetes and Terraform for deployment (implementation phase)
- OpenTelemetry, Prometheus and Grafana for observability

## Repository layout

| Path | Responsibility |
|---|---|
| `apps/` | Deployable domain services |
| `shared/` | Stable domain types and event contracts |
| `platform/` | Identity, tenant control plane, schema and data quality |
| `messaging/` | Kafka topics, ACLs, contracts and DLQ operations |
| `storage/` | PostgreSQL, cache, object and analytical stores |
| `data-platform/` | Lakehouse, Spark, Airflow and Trino |
| `infrastructure/` | Docker, Kubernetes, Helm and Terraform |
| `observability/` | OpenTelemetry, metrics, dashboards and alerts |
| `security/` | Threat model, policies and secure development |
| `testing/` | Unit, contract, load, chaos and security tests |
| `benchmarks/` | Reproducible capacity scenarios |
| `docs/` | Architecture decisions, rollout and runbooks |

## Quick start

Requirements: JDK 21, Maven 3.9+, Docker and Docker Compose.

```bash
cp .env.example .env
docker compose -f compose.yaml up -d
mvn -B verify
```

The compose environment is for local development only. Change all sample credentials before using any shared environment.

## Financial correctness principles

1. A transaction is accepted only after its authoritative database transaction commits.
2. Commit transaction, idempotency record, audit and outbox atomically.
3. Treat cross-service delivery as at-least-once; consumers must be idempotent.
4. Never claim end-to-end exactly-once financial effects from Kafka/Flink semantics alone.
5. Use decimal/minor-unit-safe money and explicit ISO currency codes.
6. Preserve immutable event history; model reversals as compensating events.
7. Enforce tenant authorization at every data-access boundary.
8. Never log credentials, payment authentication data or prohibited sensitive payloads.

## Current implementation status

- [x] Java 21 Maven multi-module scaffold and service shells
- [x] Local PostgreSQL, Redis and Kafka compose environment
- [x] Baseline CI, CodeQL and dependency update configuration
- [x] Global cell, capacity, residency, tenant-isolation and DR architecture
- [x] Data platform, infrastructure, observability, security and testing folder boundaries
- [ ] Durable transaction ingestion and database migrations
- [ ] Transactional outbox publisher and consumer inbox
- [ ] Kafka schema registry, ACLs and DLQ implementation
- [ ] Executable Flink jobs and recovery tests
- [ ] Reconciliation and anomaly workflows
- [ ] Lakehouse ingestion, Spark jobs and analytical models
- [ ] Identity, tenant control plane and regional routing
- [ ] Kubernetes/Terraform deployment and secrets integration
- [ ] Load, soak, chaos, restore and regional failover evidence
- [ ] Security/legal review and production approval

## Production gate

Do not process real financial data until correctness, tenant isolation, security, observability, disaster recovery, capacity and jurisdiction-specific obligations have passed evidence-based review.

See `docs/roadmap/implementation-plan.md`, `docs/roadmap/production-maturity-gates.md` and `docs/architecture/global-scale-reference-architecture.md`.


## Phase 0 audit

- [Repository and architecture audit](docs/audits/PHASE_0_REPOSITORY_AUDIT.md)

The audit records the current PR/CI status, architecture gaps, unresolved decisions and merge blockers. It is a remote source review, not a local build or security certification.

## Engineering governance and Phase 0

- [Contributing guide](CONTRIBUTING.md)
- [Security policy](SECURITY.md)
- [Phase 0 repository audit](docs/audits/PHASE_0_REPOSITORY_AUDIT.md)
- [Initial deployment topology ADR](docs/adr/0004-initial-deployment-topology.md)
- [Money and asset model](docs/architecture/MONEY_AND_ASSET_MODEL.md)
- [Transaction state machine](docs/architecture/TRANSACTION_STATE_MACHINE.md)
- [Schema and event contract governance](docs/architecture/SCHEMA_GOVERNANCE.md)
- [Requirements traceability template](docs/roadmap/REQUIREMENTS_TRACEABILITY_TEMPLATE.md)
- [Open-source licensing decision](docs/governance/OPEN_SOURCE_LICENSE_DECISION.md)
- [Phase 0 exit status and closure gates](docs/roadmap/PHASE_0_EXIT_STATUS.md)
- [Phase 0 architecture and governance sign-off register](docs/governance/PHASE_0_SIGN_OFF.md)

## Pre-development blueprint

Before implementing the transaction engine, review the requirements and design contracts:

- [Product requirements](docs/requirements/PRODUCT_REQUIREMENTS.md)
- [System requirements](docs/requirements/SYSTEM_REQUIREMENTS.md)
- [Master architecture](docs/architecture/MASTER_ARCHITECTURE.md)
- [Canonical transaction specification](docs/architecture/TRANSACTION_SPECIFICATION.md)
- [Ledger and financial integrity](docs/architecture/LEDGER_DESIGN.md)
- [Universal integration standard](docs/integration/INTEGRATION_STANDARD.md)
- [Connector SDK specification](docs/integration/CONNECTOR_SDK_SPEC.md)
- [Provider capability matrix](docs/integration/PROVIDER_CAPABILITY_MATRIX.md)
- [Security architecture and threat model](docs/security/SECURITY_ARCHITECTURE.md)
- [Data classification and retention](docs/security/DATA_CLASSIFICATION_AND_RETENTION.md)
- [Disaster recovery and business continuity](docs/operations/DISASTER_RECOVERY_AND_BUSINESS_CONTINUITY.md)
- [Incident response](docs/operations/INCIDENT_RESPONSE.md)
- [Production readiness gate](docs/operations/PRODUCTION_READINESS.md)
- [Compliance and jurisdiction framework](docs/compliance/COMPLIANCE_AND_JURISDICTION_FRAMEWORK.md)
- [Testing strategy](docs/testing/TESTING_STRATEGY.md)
- [Pre-development exit criteria](docs/roadmap/PRE_DEVELOPMENT_EXIT_CRITERIA.md)
- [Global provider roadmap](docs/roadmap/GLOBAL_PROVIDER_ROADMAP.md)

These documents describe intended architecture and controls. A documented capability is not an implemented, tested or certified capability. The pre-development exit criteria must be reviewed before core transaction-engine implementation starts.
