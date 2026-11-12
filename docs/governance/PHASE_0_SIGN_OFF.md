# Phase 0 Architecture and Governance Sign-off

Status: **PENDING OWNER AND REVIEWER APPROVAL**
Review baseline: 2026-11-12
Scope: pre-development foundation only. This record does not authorize production workloads.

## Approval record

Complete each section with a named accountable reviewer, decision, date and evidence link. Do not treat a blank or assumed approval as approval.

| Review area | Required accountable reviewer | Decision | Evidence / conditions |
|---|---|---|---|
| Product scope and service boundary | Product owner | Pending | Confirm ingestion, intelligence, reconciliation and whether payment initiation/custody are excluded |
| Architecture and deployment topology | Platform architect | Pending | Review master architecture and ADR 0004 |
| Financial domain and ledger invariants | Qualified financial-domain/accounting reviewer | Pending | Approve money/asset precision, posting, reversals, legal-entity and balancing rules |
| Integration contracts | Integration/platform owner | Pending | Approve canonical envelope, connector capability model, signatures, idempotency and provider evidence |
| Security and privacy | Security/privacy owner | Pending | Review threat model, tenant isolation, secrets, access, retention and data residency |
| Compliance and jurisdiction | Qualified legal/compliance reviewer | Pending | Determine applicable laws, licensing perimeter and launch-market obligations |
| Reliability and operations | SRE/operations owner | Pending | Approve SLO methodology, recovery objectives, restore/failover tests and incident ownership |
| Quality and delivery | Engineering owner | Pending | Confirm CI, CodeQL, dependency, secret and infrastructure checks pass on current PR heads |
| Repository licensing | Repository owner | Pending | Select a license or explicitly retain proprietary/no-license status |

## Decisions required before implementation

1. Define first-release transaction families and explicit exclusions. "Any transaction" is not a testable scope.
2. Confirm the platform's role: financial-data ingestion and intelligence only, or any payment initiation, authorization, custody, execution or settlement activity.
3. Approve launch jurisdictions and the applicable regulatory assessment.
4. Approve asset metadata, precision, rounding, valuation and FX ownership.
5. Approve ledger accounting model and posting authority.
6. Approve the first provider integrations based on access, contract rights, sandbox availability and certification requirements.
7. Confirm data residency, retention, deletion, legal hold and tenant export policies.
8. Select an open-source license or state that the repository remains proprietary. Do not imply an open-source license exists until a LICENSE file is added.

## Evidence required to close technical verification

- [ ] Java 21 Maven reactor build succeeds from a clean checkout.
- [ ] All tests execute and pass; test count and reports are retained.
- [ ] CI passes on PR #1, #2 and #3 current heads.
- [ ] Quality baseline passes on PR #3.
- [ ] CodeQL passes on each applicable current head.
- [ ] Dependency vulnerability and secret scans have documented results.
- [ ] Docker Compose local development stack starts and health checks pass.
- [ ] Configuration and secret-handling review is complete.
- [ ] Branch bases and mergeability are rechecked after each earlier PR is merged.

## Current evidence note

As of 2026-11-12, the latest observed workflow runs on all three PR heads concluded in failure. The connected GitHub job-log endpoint returned `BlobNotFound`, and step summaries were empty. No root cause is asserted. The latest PR #3 head is mergeable according to GitHub's mergeability snapshot, but that does not override failed checks or pending approvals.

## Authorization boundary

After all approvals and verification gates are complete, the owner may authorize foundational implementation. This sign-off is not a production-readiness certification, regulatory approval, provider certification or permission to process real financial transactions.
