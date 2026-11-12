# Master Architecture

## Architectural style
Use a modular Java platform with independently deployable services only where scaling, isolation, release cadence or ownership justify separation. Avoid premature microservice fragmentation. Java 21 LTS and Spring Boot 3.x are the baseline pending compatibility review at implementation time.

## Logical planes
1. Edge and integration: API gateway, provider adapters, webhook ingress, file and CDC ingestion.
2. Transaction plane: canonicalization, validation, idempotency, state machine, durable acceptance and event publication.
3. Financial plane: accounts, journal/ledger, reversals, adjustments, settlement and reconciliation.
4. Intelligence plane: rules, velocity, anomaly detection, case management and explainability.
5. Data plane: streaming, historical lakehouse, analytics, lineage and quality.
6. Control plane: identity, tenant registry, policy, configuration, quotas, metering and developer experience.
7. Operations plane: observability, security, deployment, incident response and disaster recovery.

## Core data flow
Source -> authenticated adapter -> bounded ingress -> schema validation -> canonical envelope -> idempotency check -> durable database transaction (record + inbox/outbox) -> asynchronous event processing -> domain workflows -> reconciliation and analytics -> tenant-scoped API/alerts.

## Data authority
The operational relational store is authoritative for accepted financial records and ledger postings. Kafka transports events; it is not the ledger of record. Analytical stores and lakehouse tables are derived, rebuildable projections. Cache entries are never authoritative.

## Regional topology
Use regional cells with tenant home-region write authority. Global routing resolves tenant placement. Cross-region failover requires fencing, a single-writer decision, replication-position validation and explicit recovery approval. Do not enable multi-primary ledger writes by default.

## Resilience
Every remote call has deadlines, bounded retries with jitter, circuit breakers and concurrency limits. Use backpressure, queue-age monitoring, bulkheads, load shedding and graceful degradation.

## Security boundaries
Authenticate every workload; authorize every operation against server-derived tenant context; separate control plane and data plane; isolate secrets and keys; audit privileged operations.

## Architecture rules
- No floating-point financial amounts.
- No direct writes to ledger tables outside the ledger domain.
- No tenant identity trusted from unverified client payloads.
- No acknowledgement before durable acceptance.
- No blind retry of non-idempotent external actions.
- No analytical workload on the critical write path.
- No production secrets in repository or logs.
