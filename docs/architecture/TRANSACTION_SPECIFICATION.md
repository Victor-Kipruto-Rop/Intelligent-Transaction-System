# Canonical Transaction Specification

## Modeling approach
A transaction is not a single universal shape. Use a stable envelope with a typed, versioned domain payload. Preserve provider-specific fields in a controlled extension map; do not allow arbitrary extensions to override trusted canonical fields.

## Envelope fields
- internalTransactionId (globally unique opaque identifier)
- tenantId (resolved from authenticated connector context)
- source: provider, connectorId, connectorVersion, sourceAccountReference
- sourceTransactionId and sourceEventId
- family and operation
- lifecycle status and statusReason
- amount: decimal string or integer minor units, currency ISO 4217 code, scale and rounding policy
- occurredAt, receivedAt, acceptedAt, processedAt (UTC instants)
- direction and debit/credit semantics where applicable
- counterparty references with classification and masking policy
- correlationId, causationId, idempotencyKey
- schemaVersion, payloadReference, provenanceReference
- reconciliation state and risk/case references

## Domain payload families
Payment, transfer, card authorization/capture/refund/chargeback, mobile-money, bank-entry, journal, settlement, lending, FX, wallet, securities and insurance. Each family defines required fields, legal transitions, amount semantics and validation.

## Money rules
Use BigDecimal with explicit scale and rounding mode or integer minor units with currency metadata. Never use float/double. Never infer scale from locale. FX conversion must retain source amount, target amount, rate, rate source, timestamp, fees and rounding delta. Do not aggregate different currencies without an explicit conversion policy.

## Time and ordering
Store instants in UTC and preserve provider timezone/offset and original timestamp text where useful. Distinguish business occurrence time from ingestion and processing time. Ordering guarantees are scoped by provider/account/key and must be documented; global total ordering is not assumed.

## Lifecycle
Received -> authenticated -> validated -> deduplicated -> accepted -> processing -> processed -> reconciled/exception. Provider status and platform processing status are separate dimensions. Corrections, reversals and refunds are linked compensating events, not destructive mutation of history.

## Invalid data
Reject malformed or unauthorized requests at the boundary. Quarantine authenticated but semantically unprocessable records with reason codes and replay controls. Never silently drop data.

## Compatibility
Schemas are versioned. Additive changes are preferred. Breaking changes require new major schema/API versions, compatibility tests and migration windows.
