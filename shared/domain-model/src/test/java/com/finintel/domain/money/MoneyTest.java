package com.finintel.domain.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Currency;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void retainsExactDecimalAmountAndCurrency() {
        Money money = new Money(new BigDecimal("1250.50"), Currency.getInstance("KES"));
        assertEquals(new BigDecimal("1250.50"), money.amount());
        assertEquals("KES", money.currency().getCurrencyCode());
    }

    @Test
    void rejectsExcessCurrencyPrecision() {
        assertThrows(IllegalArgumentException.class,
                () -> new Money(new BigDecimal("1.234"), Currency.getInstance("KES")));
    }
}
