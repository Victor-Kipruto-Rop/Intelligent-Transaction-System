# Universal Integration Standard

## Connector contract
Every connector implements a common lifecycle: capabilities, configuration validation, credential validation, health check, fetch/receive, parse, normalize, acknowledge, checkpoint, retry classification and shutdown. Provider-specific behavior remains inside the adapter.

## Supported transport families
REST/JSON, GraphQL, gRPC, signed webhooks, SFTP/file drops, CSV, XML, ISO 20022, database CDC and event brokers. Support is capability-based; a transport label alone does not establish compatibility.

## Connector manifest
Declare provider, regions, supported transaction families, auth method, webhook signature scheme, polling limits, rate limits, idempotency behavior, ordering semantics, pagination, backfill support, schema versions, data classification and operational owner.

## Webhooks
Verify signature over exact raw bytes, enforce timestamp tolerance, prevent replay, cap body size, authenticate tenant mapping, persist durable inbox record before 2xx acknowledgement, and process asynchronously. Keep provider-specific verification logic isolated and tested. Never trust forwarded tenant IDs.

## Polling and files
Use checkpoints, stable pagination, checksums, atomic file handoff, quarantine, partial-file detection and resumable backfills. Do not mark a checkpoint advanced until records are durably accepted.

## Retries
Classify errors into transient, permanent, authentication, rate-limited and ambiguous outcomes. Use bounded exponential backoff with jitter and Retry-After support. Avoid retrying ambiguous external commands without idempotency or status lookup.

## Connector certification
Every connector needs sandbox fixtures, contract tests, malformed payload tests, signature tests, replay tests, rate-limit tests, outage tests, reconciliation samples and documented provider limitations.

## Provider roadmap
M-Pesa, Airtel Money, MTN MoMo, banks/Open Banking, card processors, payment gateways, accounting/ERP, wallet platforms and internal ledgers are planned connector families. Names in this list are targets, not claims of existing integrations.
