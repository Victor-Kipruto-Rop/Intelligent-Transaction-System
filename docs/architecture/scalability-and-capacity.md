# Scalability and capacity model

Planning test envelopes, not guarantees: 1,000 sustained API RPS, 5,000 burst RPS, 10,000 concurrent sessions, and millions of events/day. Revisit after cloud-specific profiling.

Measure endpoint mix, p50/p95/p99, errors, payload sizes, tenant skew, DB TPS/connections/IOPS/locks, outbox age, Kafka bytes/records/lag, Flink event-time lag/checkpoints, cache hit ratio, lakehouse ingest and cost.

Bound queues, threads, pools, payloads, concurrency and retries. Autoscaling must respect DB and broker capacity. Partition tables/topics only with measured access patterns and key distribution. Every benchmark verifies transaction counts and monetary totals.