package com.oguzhan.wallet.domain.transaction.converters;

import com.oguzhan.wallet.domain.transaction.TransactionStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransactionStatusAttributeConverter implements AttributeConverter<TransactionStatus,String> {
    @Override
    public String convertToDatabaseColumn(TransactionStatus transactionStatus) {
        return transactionStatus.getCode();
    }

    @Override
    public TransactionStatus convertToEntityAttribute(String code) {
        return TransactionStatus.fromCode(code);
    }
}
