# Transaction State Machine

## Status

Proposed domain contract. Provider status, ingestion status, processing status, ledger status and reconciliation status are independent dimensions. A single enum must not represent all of them.

## Separate state dimensions

1. **Ingestion:** RECEIVED, AUTHENTICATED, REJECTED_AT_BOUNDARY, DURABLY_ACCEPTED, QUARANTINED.
2. **Processing:** NOT_STARTED, QUEUED, PROCESSING, PROCESSED, RETRYABLE_FAILURE, TERMINAL_FAILURE.
3. **Provider observation:** provider-defined status mapped through a versioned adapter while retaining the original provider code and description.
4. **Financial posting:** NOT_ELIGIBLE, PENDING, POSTED, REVERSED, ADJUSTED.
5. **Reconciliation:** NOT_REQUESTED, PENDING, MATCHED, PARTIALLY_MATCHED, UNMATCHED, EXCEPTION, CLOSED.

These are illustrative controlled vocabularies. Each dimension needs an approved transition table and ownership rules before code is written.

## Transition rules

- Every transition records prior state, new state, reason code, actor/system identity, timestamp and correlation/provenance reference.
- Reject illegal transitions; do not silently coerce them.
- Duplicate deliveries must not cause duplicate financial effects.
- Retryable failures require bounded retry policy and observable exhaustion.
- Terminal failures require an explicit remediation or closure path.
- Reversals and refunds are distinct business operations and must retain links to their original records.
- Provider status changes do not automatically authorize ledger postings.
- A record may be durably accepted even while downstream processing remains pending.

## Ordering and concurrency

Define ordering scope by tenant, provider, account or transaction aggregate as required. Use optimistic version checks or deterministic locking for competing state changes. Never claim global ordering unless it is implemented and measured.

## Required verification

Property-based and model-based tests must cover legal/illegal transitions, duplicate events, out-of-order notifications, concurrent updates, retry exhaustion, reversal chains and replay after recovery.
