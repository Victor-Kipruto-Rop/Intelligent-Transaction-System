# Phase 0 Repository and Architecture Audit

Audit date: 2026-11-12
Scope: pull requests #1, #2 and #3, their changed-file inventories, key Maven/Java/event-contract files, workflow definitions and recorded GitHub Actions results.
Audit type: remote repository inspection. No local Maven build, Docker run, dependency scan or penetration test was executed.

## Executive result

**Decision: NOT READY TO MERGE OR START CORE TRANSACTION-ENGINE IMPLEMENTATION.**

The three draft PRs are open and GitHub reports them as mergeable at the time of this audit. PR #1 and PR #2 have recorded failed GitHub Actions runs. PR #3 has no workflow run returned for its head commit. Failure logs could not be retrieved through the connected GitHub interface, so the exact causes of the failed runs are not asserted.

## Pull request inventory

| PR | Scope | Changed files | Additions | Deletions | Current recorded state |
|---|---|---:|---:|---:|---|
| #1 | Initial Java/Maven scaffold | 102 | 1,448 | 1 | Open, draft, mergeable; CI and CodeQL failed |
| #2 | Global-scale architecture | 48 | 252 | 46 | Open, draft, mergeable; CI failed |
| #3 | Pre-development blueprint | 37 | 615 | 0 | Open, draft, mergeable; no workflow run returned |

PRs are stacked: #1 targets main, #2 targets #1's scaffold branch, and #3 targets #2's architecture branch. Preserve this merge order and re-check each base/head after any rebasing or retargeting.

## Findings

### P0 - CI and security workflow evidence is incomplete

- Recorded PR #1 CodeQL and CI runs concluded failure.
- Recorded PR #2 CI run concluded failure.
- Workflow job-log retrieval returned a missing-blob response; the exact failure messages are unavailable.
- PR #3 head has no workflow run returned.
- PR #1 CI pull_request trigger targets main only. PR #2 changes the workflow to target main and scaffold/**. PR #3 is based on architecture/**, which is not included in that pull_request target list.
- PR #2 quality workflow only targets pull requests into main and pushes to main or architecture/**. It does not validate PR #3's foundation/** branch.
- CodeQL workflow only triggers for pull requests into main, pushes to main and a scheduled run. The stacked PRs are not all covered by PR-triggered CodeQL.

Required remediation:
1. Reproduce the Maven verification locally or in a fresh GitHub Actions run and record the exact failing step.
2. Align CI and quality workflow triggers with the actual branch and stacked-PR strategy.
3. Ensure PR #3 receives required build, test and security checks.
4. Add explicit dependency, secret, container and IaC scanning plus SBOM generation as appropriate.
5. Make required checks branch-protection rules after the correct checks are stable.
6. Do not merge on the basis of mergeability alone.

### P1 - Deployment topology is not yet a single approved decision

PR #1's root Maven aggregator defines eleven application modules: ingestion, transaction processing, streaming, reconciliation, anomaly detection, analytics, batch, notification and API gateway, plus shared modules. These are service-shaped modules with application entry points.

PR #3's master architecture says to begin with a modular Java platform and split services only where scaling, isolation, ownership or release cadence justify it.

These positions can be reconciled, but the first release topology must be explicitly approved. Recommended decision: start with a modular monolith or a very small number of deployable runtime units, while keeping strict domain/module boundaries. Extract independently deployable services only when a measured need exists. Avoid deploying eleven largely empty services on day one.

### P1 - Canonical money and transaction types need a deeper contract

The initial Java Money record wraps BigDecimal and java.util.Currency and rejects scales above Currency.getDefaultFractionDigits(). This is a useful prototype, not a complete global financial amount model.

Open decisions:
- Define currency/asset metadata and scale policy, including non-ISO assets if in scope.
- Specify whether scale is normalized or rejected and how rounding is explicitly performed.
- Define limits and overflow behavior for integer minor-unit event fields.
- Separate amount, currency/asset, direction, fees, FX rate and settlement amount.
- Define treatment of zero-decimal and three-decimal currencies, unknown currencies, crypto assets and securities if those are supported.
- Avoid assuming one java.util.Currency model covers every instrument.

The initial TransactionStatus enum is also narrower than the documented lifecycle. It lacks explicit ACCEPTED, RECONCILIATION_PENDING, RECONCILED and EXCEPTION states and does not distinguish provider-reported status from platform processing status. Replace the enum-only lifecycle with a versioned state machine and separate status dimensions.

### P1 - Event contract is too small for the stated platform scope

The first Avro TransactionReceived schema is a useful placeholder but contains only a small set of fields. It needs a formal compatibility policy and a fuller event envelope including event type, event ID, tenant context derived from authenticated source identity, source/provider identity, transaction family, operation, schema version, event/occurrence/ingestion times, correlation/causation IDs, idempotency identity, provenance references and typed payload strategy.

Avoid blindly putting raw sensitive provider payloads into Kafka. Store protected raw evidence separately and reference it under retention and access controls.

### P1 - Provider and instrument scope needs explicit boundaries

The provider roadmap is broad and correctly labels integrations as planned. Before implementation, define a capability matrix by provider product, country, transaction family, operation, authentication, idempotency, callback signature, rate limits, statement/reconciliation source, reversals and certification level.

Do not treat payment instruction, provider notification, authorization, capture, bank entry, journal posting, settlement and reconciliation as interchangeable events. Define separate domain contracts for payments, bank entries, card events, mobile-money events, journals, FX and other instruments that are actually in scope.

### P1 - Security controls are documented but not implemented or evidenced

The architecture and threat model are useful design material. The repository audit did not verify working authentication, tenant isolation, encryption, key management, authorization, webhook verification, audit immutability, DAST/SAST/SCA, container/IaC scanning, signed releases or penetration testing.

Required before production: implementation, automated tests, evidence, operational ownership and independent review. No zero-vulnerability or certification claim is appropriate.

### P1 - Local compose environment is not production infrastructure

The compose file provisions single-node PostgreSQL, Redis and Kafka with local-development defaults. It is suitable as a development dependency environment only. It does not establish HA, TLS, broker authentication/ACLs, managed backups, multi-region failover, production secrets or safe external exposure.

Keep local services bound to loopback where possible, use non-production-only credentials, document the local-only boundary and design production infrastructure separately.

### P2 - Repository governance and public-release readiness are incomplete

The inspected changed-file inventories do not show a root LICENSE, SECURITY.md vulnerability disclosure policy, CONTRIBUTING guide or support policy. Confirm repository visibility and choose an appropriate license before public release. Add maintainer/release ownership, security contact, vulnerability intake, dependency update policy and supported-version policy.

### P2 - Architecture documentation needs traceability

The PRs add many useful documents, but the next step is a single requirements traceability matrix mapping:
- requirement ID
- business owner
- architecture decision
- module/service owner
- data classification
- threat/control
- API/event schema
- test evidence
- operational runbook
- release gate

This prevents documents from becoming disconnected plans.

## Recommended remediation sequence

1. Recover/re-run CI and determine the actual build failures.
2. Fix workflow triggers and make PR #3 verifiable.
3. Approve deployment topology and module boundaries.
4. Finalize money/asset precision and transaction state machines.
5. Finalize event contracts, schema compatibility and delivery semantics.
6. Finalize connector capability manifests and provider certification gates.
7. Add requirements traceability and public repository governance files.
8. Run architecture and security reviews; record decisions and residual risks.
9. Only then approve the pre-development exit gate for foundational implementation.

## Audit limitations

This is a remote source review, not a local build or a security audit. The Maven build, tests, Docker Compose startup, schema validation, dependency vulnerabilities, secrets scan, IaC scan, runtime behavior, throughput and recovery procedures have not been independently executed in this audit. Workflow logs were unavailable from the connected GitHub interface. These items remain unverified, not passed.

## Decision

Keep PRs #1-#3 as drafts until the P0 CI evidence and P1 architecture decisions are addressed. No real financial data, provider credentials or production workloads should be connected yet.
