package com.oguzhan.wallet.domain.exceptions;

public class CurrencyMismatch extends DomainException {
    public CurrencyMismatch(String message) {
        super(message);
    }
}
