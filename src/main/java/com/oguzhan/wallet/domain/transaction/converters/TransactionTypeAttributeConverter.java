package com.oguzhan.wallet.domain.transaction.converters;

import com.oguzhan.wallet.domain.transaction.TransactionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransactionTypeAttributeConverter implements AttributeConverter<TransactionType,String> {
    @Override
    public String convertToDatabaseColumn(TransactionType transactionType) {
        return transactionType.getCode();
    }

    @Override
    public TransactionType convertToEntityAttribute(String code) {
        return TransactionType.fromCode(code);
    }
}
