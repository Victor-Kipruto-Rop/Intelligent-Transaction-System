# Contributing

## Current project stage

ITS is in its pre-development foundation stage. Do not introduce production transaction processing, payment execution or live financial-data handling until the relevant architecture decisions and pre-development exit criteria are approved.

## Before opening a pull request

1. Read the root README and relevant architecture decisions.
2. Link the change to a requirement, issue or approved decision.
3. Keep changes focused and preserve module boundaries.
4. Add or update tests for behavior and financial invariants.
5. Update API, event, security, operational and migration documentation when affected.
6. Run `mvn -B -ntp verify` for Java changes.
7. Never commit secrets, personal financial data, provider credentials or production payloads.
8. Include rollback and data-migration considerations for persistent changes.

## Financial correctness

- Never use binary floating-point types for money.
- Never mutate a posted journal entry; use an approved compensating entry.
- Define idempotency scope and replay behavior for externally sourced records.
- Preserve source provenance and distinguish event receipt from financial posting.
- Do not claim exactly-once business effects based only on broker guarantees.
- Add tests for rounding, currency, duplicate delivery, concurrency, reversals and tenant isolation where applicable.

## Pull request checklist

- [ ] Scope and acceptance criteria are clear.
- [ ] Architecture impact and ADR references are documented.
- [ ] Tests cover success, invalid input, retries and failure paths.
- [ ] Tenant authorization and data classification are reviewed.
- [ ] Schema/API compatibility is assessed.
- [ ] Logs and telemetry do not expose secrets or sensitive financial data.
- [ ] Migration, rollback and operational notes are included.
- [ ] CI and required security checks pass.

## Review policy

Changes to ledger invariants, transaction lifecycle, money representation, tenant isolation, cryptography, data residency or event delivery require explicit domain/security architecture review. Do not merge a change solely because GitHub reports it as mergeable.
