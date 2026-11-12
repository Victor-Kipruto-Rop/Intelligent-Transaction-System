# Global-scale reference architecture

Use regional cells. Each cell has edge, stateless Java services, regional Kafka, operational PostgreSQL, cache and telemetry. Assign each tenant a home region for authoritative writes. Global edge routes writes to that region. Do not enable multi-primary writes to one ledger by default.

## Request path
WAF/DNS -> API gateway -> tenant-aware ingestion -> atomic PostgreSQL transaction + idempotency + audit + outbox -> Kafka -> independently scaled consumers/Flink -> reconciliation and anomaly workflows -> Iceberg lakehouse -> read models/analytics.

## Scale boundaries
- Stateless API and workers scale horizontally, with bounded pools and admission control.
- PostgreSQL remains authoritative; tune indexes, partitioning, pooling and replicas from measured workloads.
- Kafka partitions use stable keys; consumers scale up to useful partition parallelism.
- Flink uses keyed state, checkpoints, backpressure monitoring and savepoint upgrades.
- Spark/lakehouse workloads are isolated from transaction writes.
- Regional recovery requires writer fencing, replication-position validation and reconciliation.

At-least-once delivery plus outbox/inbox/idempotency is the baseline. Exactly-once stream processing does not guarantee exactly-once external financial effects.