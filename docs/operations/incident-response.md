# Incident response runbook (starter)

1. Declare incident severity and incident commander.
2. Identify affected tenants, source systems, event ranges and service dependencies.
3. Preserve logs, traces, broker offsets, database snapshots and audit evidence.
4. Stop unsafe replay or automated actions if financial correctness is uncertain.
5. Verify authoritative database state before replaying messages.
6. Replay from a known offset/checkpoint using idempotent consumers.
7. Reconcile internal records against source/provider evidence.
8. Record timeline, root cause, customer impact and corrective actions.

Never manually edit financial transaction history to hide an incident. Use an auditable compensating event or controlled correction workflow.
