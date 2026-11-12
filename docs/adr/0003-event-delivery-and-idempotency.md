# ADR 0003: At-least-once delivery

Status: Proposed. Date: 2026-11-12.

Assume at-least-once across services. Use transactional outbox, consumer inbox/deduplication, tenant-scoped business idempotency and reconciliation. Do not promise end-to-end exactly-once financial effects based only on Kafka/Flink semantics. External side effects need provider idempotency or compensating/reconciliation workflow.