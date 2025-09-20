package com.oguzhan.wallet.domain.exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}
