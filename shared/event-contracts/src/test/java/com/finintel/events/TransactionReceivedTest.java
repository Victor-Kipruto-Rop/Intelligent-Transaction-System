package com.finintel.events;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.finintel.domain.money.Money;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class TransactionReceivedTest {
    @Test
    void rejectsUnsupportedSchemaVersion() {
        assertThrows(IllegalArgumentException.class, () -> new TransactionReceived(
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), "TEST", "ref-1",
                new Money(new BigDecimal("10.00"), Currency.getInstance("KES")),
                Instant.now(), Instant.now(), 0));
    }
}
