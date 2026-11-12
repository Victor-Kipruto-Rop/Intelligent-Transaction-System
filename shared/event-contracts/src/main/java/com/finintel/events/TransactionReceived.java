package com.finintel.events;

import com.finintel.domain.money.Money;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/** Versioned logical contract; serialization and schema compatibility are managed separately. */
public record TransactionReceived(
        UUID eventId,
        UUID tenantId,
        UUID transactionId,
        String source,
        String externalReference,
        Money amount,
        Instant occurredAt,
        Instant receivedAt,
        int schemaVersion) {
    public TransactionReceived {
        Objects.requireNonNull(eventId, "eventId");
        Objects.requireNonNull(tenantId, "tenantId");
        Objects.requireNonNull(transactionId, "transactionId");
        Objects.requireNonNull(source, "source");
        Objects.requireNonNull(externalReference, "externalReference");
        Objects.requireNonNull(amount, "amount");
        Objects.requireNonNull(occurredAt, "occurredAt");
        Objects.requireNonNull(receivedAt, "receivedAt");
        if (schemaVersion < 1) {
            throw new IllegalArgumentException("schemaVersion must be positive");
        }
    }
}
