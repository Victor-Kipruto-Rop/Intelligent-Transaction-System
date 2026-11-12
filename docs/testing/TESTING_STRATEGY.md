# Testing Strategy

## Test layers
Unit, component, integration, provider contract, API compatibility, end-to-end, migration, financial invariants, concurrency, security, performance, stress, soak, chaos, restore and regional failover.

## Financial correctness scenarios
Balanced and unbalanced journals; currency scale and rounding; duplicate source event; duplicate idempotency key with same/different payload; out-of-order status; reversal after posting; partial failure; retry after timeout; concurrent account posting; period close; reconciliation mismatch; replay after consumer crash.

## Connector scenarios
Valid and invalid signatures, stale timestamp, replay, malformed payload, oversized request, provider rate limit, pagination gap, duplicate page, provider outage, ambiguous timeout, schema drift and backfill restart.

## Multi-tenant scenarios
Cross-tenant object references, guessed IDs, cache key collisions, queue routing, exports, search, admin support access and database policy enforcement.

## Test data
Use synthetic or properly anonymized fixtures. Never place production credentials or unapproved customer data in the repository.

## Quality gates
Tests must be deterministic, isolated, repeatable and attached to the change. Critical financial and authorization tests block merge.
