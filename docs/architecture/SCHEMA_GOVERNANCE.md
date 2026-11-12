# Schema and Event Contract Governance

## Status

Pre-implementation governance standard.

## Contract ownership

Every public API and event schema has an owning domain, named maintainer, stable identifier, version, lifecycle status and compatibility policy. No producer may change a shared schema without review by its owner.

## Event envelope

The common envelope should define event ID and type, schema identifier/version, source/provider/connector identity, tenant context derived from authenticated integration identity, aggregate identity, correlation and causation IDs, idempotency identity, occurrence and receipt timestamps, provenance references and a typed payload.

Sensitive raw provider data should not be copied into general-purpose event streams. Store protected evidence separately and reference it under explicit access, encryption and retention controls.

## Compatibility

- Prefer additive optional fields with documented defaults.
- Do not reinterpret an existing field or unit in place.
- Breaking changes require a new major contract version and a migration window.
- Consumers must tolerate documented unknown fields and reject unsupported major versions safely.
- Compatibility is checked in CI against the registry or approved schema history.
- Retired versions have an owner, sunset date and consumer migration evidence.

## Delivery semantics

Assume messages may be duplicated, delayed, retried or observed out of order. Define deduplication scope and retention. Acknowledge externally delivered data only after durable acceptance. Use transactional outbox/inbox patterns where required. Broker transactions do not alone guarantee exactly-once financial effects.

## Required tests

Schema parsing, compatibility, unknown-field behavior, invalid payloads, replay, duplicate delivery, poison-message handling, retention and consumer migration tests are required before a contract is released.
