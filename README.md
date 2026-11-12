# Intelligent Transaction System

A production-oriented Java data platform for real-time financial transaction intelligence.

> **Scaffold status:** repository foundation and service boundaries. This is not yet a production payment-processing system. Integrations, security policies, deployment manifests and operational controls must be implemented and verified before handling real financial data.

## Goals

- Securely ingest financial transaction events.
- Validate, persist and publish events reliably.
- Process streams and detect anomalies.
- Reconcile internal records with external statements.
- Build historical analytical datasets.
- Provide observable, recoverable, tenant-aware services.

## Technology baseline

- Java 21 LTS, Maven multi-module build
- Spring Boot 3.x services
- PostgreSQL and Flyway
- Apache Kafka for event distribution
- Apache Flink for stream processing (integration phase)
- Apache Spark, Parquet and Apache Iceberg for batch/lakehouse workloads (integration phase)
- Redis for cache and ephemeral coordination
- Docker Compose for local development
- OpenTelemetry, Prometheus and Grafana for observability

Exact component versions are centrally managed and should be upgraded through reviewed dependency changes.

## Repository layout

| Path | Responsibility |
|---|---|
| `apps/` | Deployable application services |
| `shared/` | Reusable domain types and event contracts |
| `platform/` | Identity, schema, quality and control-plane designs |
| `data-platform/` | Lakehouse, batch and orchestration assets |
| `infrastructure/` | Containers, Kubernetes and Terraform |
| `observability/` | Metrics, traces, logs and dashboards |
| `security/` | Threat models and security policies |
| `testing/` | Integration, contract, E2E and resilience tests |
| `docs/` | Architecture decisions, runbooks and operating guides |

## Quick start

Requirements: JDK 21, Maven 3.9+, Docker and Docker Compose.

```bash
cp .env.example .env
docker compose -f compose.yaml up -d
mvn -B verify
```

The compose environment is for local development only. Change all sample credentials before using any shared environment.

## Financial correctness principles

1. PostgreSQL is the authoritative operational store for accepted transaction state.
2. Use a transactional outbox to publish database changes reliably.
3. Kafka delivery is treated as at-least-once; consumers must be idempotent.
4. Do not claim end-to-end exactly-once financial effects based solely on Kafka transactions.
5. Use decimal arithmetic and explicit ISO currency codes. Never use binary floating point for money.
6. Preserve immutable event/audit history and model reversals as compensating events.
7. Enforce tenant authorization at every data-access boundary.
8. Never store PAN, CVV, PIN, credentials or secrets in logs or event payloads.

## Current implementation status

- [x] Repository and Maven module scaffold
- [x] Local dependency compose file
- [x] CI workflow and baseline tests
- [x] Architecture and security documentation
- [ ] Transaction ingestion and durable persistence
- [ ] Transactional outbox publisher
- [ ] Kafka schemas, topics and ACLs
- [ ] Flink streaming jobs and recovery tests
- [ ] Reconciliation matching engine
- [ ] Anomaly rules and scoring
- [ ] Lakehouse ingestion and analytical models
- [ ] Production security, deployment and DR verification

See [docs/roadmap/implementation-plan.md](docs/roadmap/implementation-plan.md) and [docs/architecture/system-overview.md](docs/architecture/system-overview.md).
