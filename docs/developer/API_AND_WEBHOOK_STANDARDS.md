# API and Webhook Standards

Publish versioned OpenAPI specifications, consistent error envelopes, pagination, filtering, request/correlation IDs, idempotency keys for writes and rate-limit headers. Validate content types and payload limits; never leak stack traces.

Use scoped credentials and modern identity protocols. Tenant identity is server-derived. Secrets are revocable and rotated.

Incoming webhooks: verify exact raw-body signature, timestamp and replay; persist a durable inbox record before 2xx acknowledgement; process asynchronously.

Outgoing webhooks: sign events, include event ID/timestamp/schema version, retry with bounded backoff, expose delivery history and support secret rotation. Consumers tolerate duplicates and out-of-order delivery.

Additive evolution by default. Breaking changes require a major version, contract tests, migration guide and deprecation window. Document timeouts, rate limits, quotas, retry semantics and consistency.
