package com.finintel.domain.transaction;

public enum TransactionStatus {
    RECEIVED,
    VALIDATED,
    PROCESSING,
    PROCESSED,
    REJECTED,
    FAILED,
    REVERSED
}
