# Production Readiness Gate

Production approval is an evidence-based decision, not a checklist of planned folders.

## Required gates
1. Product and legal scope approved.
2. Architecture and threat model reviewed.
3. Tenant isolation and authorization independently tested.
4. Financial invariants and ledger reconciliation proven.
5. Idempotency, outbox/inbox and replay tested under failure.
6. Connector certification completed for each released provider.
7. Security scanning and penetration testing reviewed.
8. Load, stress, soak and capacity tests completed on representative infrastructure.
9. Backups and restore drills verified.
10. Regional failover and split-brain controls tested if multi-region is enabled.
11. SLOs, dashboards, alerts, on-call and runbooks operational.
12. Data residency, retention and regulatory assessments approved.
13. Rollback, release and support processes staffed.
14. Customer terms, privacy notice and incident disclosure process reviewed.

Each gate records evidence URL, reviewer, date, scope, result and unresolved risk. A failed critical gate blocks production.
