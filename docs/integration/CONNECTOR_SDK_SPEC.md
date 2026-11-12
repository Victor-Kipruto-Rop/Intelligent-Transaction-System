# Connector SDK Specification

## Goals
Enable first-party and approved third-party developers to add integrations without changing transaction-core code.

## SDK modules
- Connector SPI and lifecycle interfaces
- Typed configuration and secret references
- Capability and provider manifest
- Authentication and signature verification helpers
- Canonical mapping utilities
- Pagination and checkpoint helpers
- Retry classification and rate-limit support
- Structured telemetry and redaction
- Test kit with fixtures, contract assertions and fake clocks

## Isolation
Connectors are untrusted extension code. Initial production architecture should use reviewed, signed, versioned connector packages or isolated connector workers. Do not load arbitrary tenant-supplied code into the core JVM.

## Compatibility
Version SDK interfaces independently. Enforce semantic versioning, compatibility tests, dependency allowlists, SBOMs and signed artifacts.

## Developer experience
Provide Java SDK first, then documented language-neutral protocol and optional Python/TypeScript SDKs. Provide sandbox credentials, sample payloads and webhook simulation.

## Acceptance
A sample connector must pass authentication, mapping, idempotency, replay, failure, tenant-isolation, observability and compatibility suites before publication.
