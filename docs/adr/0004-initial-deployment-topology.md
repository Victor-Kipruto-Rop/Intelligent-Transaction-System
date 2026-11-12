# ADR 0004: Initial Deployment Topology

- Status: Proposed for architecture review
- Date: 2026-11-12
- Decision owners: product, platform architecture and operations

## Context

The initial Maven aggregator declares numerous service-shaped applications. The master architecture also advises against premature microservice fragmentation. Starting every scaffolded application as an independently deployed service increases operational burden before domain boundaries, load profiles and ownership are proven.

## Proposed decision

Begin with a modular Java platform and a deliberately small number of deployable runtime units. Enforce domain ownership through module APIs, dependency rules and package boundaries. Keep financial ledger writes inside the ledger domain. Treat ingestion adapters and asynchronous workers as separate runtime units only when their isolation, scaling or availability requirements justify it.

Do not interpret the current Maven module list as a requirement to deploy every module independently.

## Extraction criteria

Extract a module into an independently deployable service only when evidence demonstrates one or more of:
- materially different scaling or resource profile;
- separate security or data-residency boundary;
- independent availability or release requirements;
- clear team ownership and operational readiness;
- measured contention or failure isolation benefit.

## Consequences

Positive: smaller initial operational footprint, easier local development, fewer network failure modes and clearer end-to-end debugging.

Trade-offs: disciplined module boundaries and dependency rules are essential; a modular monolith must not become a shared-database, shared-code tangle.

## Revisit when

Load tests, domain ownership, security review or operational evidence show that a boundary should be extracted. Record the extraction plan and data/API migration before implementation.
