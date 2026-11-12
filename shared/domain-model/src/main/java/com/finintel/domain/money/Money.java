package com.finintel.domain.money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

/** Monetary value with explicit currency and decimal precision. */
public record Money(BigDecimal amount, Currency currency) {
    public Money {
        Objects.requireNonNull(amount, "amount");
        Objects.requireNonNull(currency, "currency");
        if (amount.scale() > currency.getDefaultFractionDigits() && currency.getDefaultFractionDigits() >= 0) {
            throw new IllegalArgumentException("Amount exceeds currency minor-unit precision");
        }
    }
}
