# Event Delivery and Processing Semantics

## Delivery model
Assume at-least-once delivery across network and broker boundaries. Exactly-once transport does not guarantee exactly-once business effects. Business idempotency is enforced at the durable write boundary.

## Transactional outbox
Commit domain state and outbox event in one database transaction. Publish asynchronously. Mark delivery progress safely. Outbox publishers are restartable and observable.

## Consumer inbox
Consumers persist message identity and processing outcome atomically with their business update. Duplicate messages return the recorded outcome without repeating financial effects.

## Ordering
Partition by stable business key where ordering is required. Include aggregate version/sequence. Detect stale and gap events. Do not assume ordering across partitions or providers.

## DLQ and replay
Dead-letter records include original event reference, error category, attempts, timestamps and schema version. Redrive requires authorization, reason, idempotency and audit. Never replay blindly into non-idempotent external side effects.

## Schema evolution
Use compatibility checks in CI, schema ownership, retention policies and explicit deprecation windows.
