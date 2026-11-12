# Kafka recovery runbook

Starter checklist: inspect broker health, consumer lag, partition leadership, under-replicated partitions and DLQ rates. Before replay, confirm the consumer is idempotent, select a bounded offset/time range, record the replay operator and reason, and compare resulting business counts and totals with the authoritative store.
