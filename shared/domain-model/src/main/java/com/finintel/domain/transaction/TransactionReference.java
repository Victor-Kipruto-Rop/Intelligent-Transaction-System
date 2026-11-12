package com.finintel.domain.transaction;

import java.util.Objects;
import java.util.UUID;

public record TransactionReference(UUID value) {
    public TransactionReference {
        Objects.requireNonNull(value, "value");
    }

    public static TransactionReference newReference() {
        return new TransactionReference(UUID.randomUUID());
    }
}
