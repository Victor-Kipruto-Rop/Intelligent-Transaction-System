# Chaos and Recovery Testing

In non-production environments inject process termination, network delay/loss, broker unavailability, database failover, expired credentials, provider throttling, disk pressure, consumer rebalance, clock skew and region isolation.

Each experiment defines hypothesis, blast radius, abort condition, expected behavior, financial invariants, telemetry, recovery procedure and owner.

Validate outbox durability, inbox deduplication, retry budgets, backpressure, circuit breakers, checkpoint recovery and ledger control totals. Production chaos requires approved change controls and a tested rollback.