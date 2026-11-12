# System overview

## Context

The Intelligent Transaction System ingests transaction facts from authorized source systems, validates and stores them, distributes durable events, detects anomalies, reconciles internal and external records, and exposes analytics.

## Logical components

- API gateway: edge routing, authentication integration, rate limits and correlation.
- Ingestion: tenant/source validation, canonicalization, idempotency and database writes.
- Operational database: authoritative accepted transaction state and immutable event/outbox records.
- Outbox publisher: reliably publishes committed changes to Kafka.
- Kafka: durable event distribution, not the sole financial system of record.
- Flink: stateful real-time processing, event-time windows and anomaly feature computation.
- Reconciliation: compares internal transactions with provider statements or settlement files.
- Lakehouse: Bronze/Silver/Gold historical datasets on object storage with Iceberg tables.
- Spark: backfills, large batch transformations and data maintenance.
- Analytics: read-optimized reporting and APIs.
- Observability: traces, metrics, structured logs, SLOs and alerting.

## Critical invariants

1. A transaction is not acknowledged as durably accepted until its authoritative database transaction commits.
2. The transaction row and outbox event are committed atomically.
3. Event consumers are idempotent and tolerate replay.
4. Reversal is a compensating event; historical facts are not silently overwritten.
5. Money is represented using decimal/minor-unit-safe values and explicit currency.
6. Every tenant-scoped read and write is authorized and constrained.
7. Operational and analytical workloads are isolated.
8. All state transitions and manual reconciliation decisions are auditable.

## Delivery semantics

The system assumes at-least-once delivery between independent components. Exactly-once processing inside a stream processor does not automatically provide exactly-once external side effects. Use idempotency keys, unique constraints, transactional outbox/inbox patterns and reconciliation to make effects safe.
