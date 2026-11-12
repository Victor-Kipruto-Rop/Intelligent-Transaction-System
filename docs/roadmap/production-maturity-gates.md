# Production maturity gates

A. Local engineering: reproducible build, tests, static analysis.
B. Durable correctness: atomic outbox, idempotency, replay, audit, reconciliation, failure injection.
C. Security/tenancy: identity, authorization, isolation, quotas, secrets, encryption, privacy and security tests.
D. Scale/resilience: load/soak/chaos, backpressure, broker recovery, DB restore, regional failover and cost model.
E. Controlled production: legal review, threat review, SLOs, on-call, incident drills, backup evidence, rollback and canary. Each gate needs test and operational evidence.