# Ingestion domain

Owns the accepted inbound transaction boundary. Implement source authentication, tenant authorization, schema validation, canonicalization, idempotency and durable persistence here. Do not publish to Kafka before the database transaction and outbox record commit atomically.
