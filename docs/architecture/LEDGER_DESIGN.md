# Ledger and Financial Integrity Design

## Purpose
The ledger is the authoritative accounting record for posted financial effects. Ingested provider events are not automatically ledger postings.

## Invariants
- Every posted journal balances per legal entity and currency.
- Posted entries are immutable; corrections use reversals and replacement entries.
- Every posting has a unique idempotency scope and source reference.
- Account, currency, period and tenant authorization are validated.
- Journal creation and posting are atomic.
- No posting is accepted without complete audit and provenance references.
- Pending, authorized, captured, settled and reconciled are distinct concepts.

## Double-entry
A journal contains at least two lines and total debits equal total credits in the same currency. Cross-currency journals require explicit FX legs and clearing accounts; unrelated currencies must never be netted to manufacture balance.

## Posting workflow
Validate command -> reserve idempotency key -> lock or version-check relevant accounts -> create journal and lines -> verify invariants -> commit -> publish outbox event. Define deterministic lock ordering to reduce deadlocks.

## Corrections
Use compensating journals, reversal references, reason codes and privileged approvals where policy requires. Never edit or delete posted entries.

## Controls
Daily control totals, trial balance, suspense-account monitoring, reconciliation breaks, period close controls, immutable audit, access segregation and independent verification.

## Performance
Partition large append-oriented tables by measured access patterns. Keep indexes aligned with tenant/account/time queries. Use bounded connection pools and transaction scopes. Do not weaken isolation or constraints without documented correctness analysis and tests.

## Not included
This document is a design contract, not an implemented ledger or accounting certification. Detailed chart-of-accounts and jurisdiction-specific accounting policies require domain review.
