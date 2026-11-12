# Kafka topic catalog

Provision topics through reviewed infrastructure-as-code, not ad hoc production commands. Define replication factor, min in-sync replicas, retention, cleanup policy, partition count, key strategy, ACLs and schema compatibility per topic.

Initial logical topics:
- transactions.received.v1
- transactions.validated.v1
- transactions.rejected.v1
- transactions.processed.v1
- transactions.failed.v1
- transactions.dlq.v1
- anomalies.detected.v1
- reconciliation.completed.v1
- reconciliation.discrepancies.v1
- notifications.requested.v1
- audit.events.v1
