package com.oguzhan.wallet.domain.transaction;


public enum TransactionType {
    TopUp("top_up", "Top Up");


    private final String code;

    private final String description;


    TransactionType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TransactionType fromCode(String code) {
        for (TransactionType type : TransactionType.values()) {
            if (type.code.equals(code)) {
                return type;
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

