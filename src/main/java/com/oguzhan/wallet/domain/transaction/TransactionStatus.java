package com.oguzhan.wallet.domain.transaction;

public enum TransactionStatus {

    PENDING("pending", "Pending"),
    COMPLETED("completed", "Completed"),
    FAILED("failed", "Failed"),
    CANCELLED("cancelled", "Cancelled"),
    REVERSED("reversed", "Reversed");


    private final String code;

    private final String description;


    TransactionStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TransactionStatus fromCode(String code) {
        for (TransactionStatus status : TransactionStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
