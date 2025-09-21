package com.oguzhan.wallet.application.exceptions;

public class InvalidBalanceForTopUpException extends ApplicationException {
    public InvalidBalanceForTopUpException(String message) {
        super(message);
    }
}
