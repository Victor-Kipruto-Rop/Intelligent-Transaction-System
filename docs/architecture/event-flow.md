# Event flow

1. An authenticated source submits an event through the gateway.
2. Ingestion validates tenant ownership, source, event schema, amount, currency and reference.
3. In one PostgreSQL transaction, ingestion writes the transaction, immutable event history and outbox row.
4. A publisher claims pending outbox rows and publishes keyed Kafka records.
5. The publisher marks delivery only after broker acknowledgement; retry may publish duplicates.
6. Consumers deduplicate by event ID or business idempotency key and persist their own processing checkpoint.
7. Flink computes streaming features and emits versioned anomaly/reconciliation events.
8. Reconciliation records matches and discrepancies without rewriting source facts.
9. Lakehouse jobs persist curated history for analytical queries.

All events should carry event ID, tenant ID, schema version, occurred-at time, received-at time, correlation ID and causation ID where applicable.
