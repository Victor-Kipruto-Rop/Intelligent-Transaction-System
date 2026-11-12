# Disaster Recovery and Business Continuity

## Objectives
Define service-specific RTO and RPO with product, legal and customer stakeholders. Do not publish objectives until recovery tests prove them.

## Recovery controls
- Encrypted automated backups and point-in-time recovery
- Cross-region backup copies with access separation
- Broker retention and event replay
- Infrastructure-as-code and configuration recovery
- Secret/key recovery procedures and break-glass controls
- Restore validation and financial control totals
- Runbooks, escalation contacts and incident command roles

## Regional failover
A tenant has one authoritative write region at a time. Failover requires fencing the old writer, validating replication position and data integrity, approving promotion, updating routing and recording the event. Never allow split-brain ledger writes.

## Exercises
Perform scheduled database restore, broker replay, service dependency outage, credential compromise and regional failover exercises. Record duration, data loss, discrepancies, lessons and remediation owners.

## Recovery exit criteria
Reconcile ledger/control totals, verify idempotency state, confirm event offsets and outbox/inbox status, validate tenant routing, restore observability and obtain operational sign-off.
