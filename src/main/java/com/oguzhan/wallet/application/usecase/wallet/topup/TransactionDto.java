package com.oguzhan.wallet.application.usecase.wallet.topup;

import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.MoneyDto;
import com.oguzhan.wallet.domain.transaction.Transaction;

import java.time.OffsetDateTime;
import java.util.UUID;

public record TransactionDto(
        UUID id,
        MoneyDto amount,
        String type,
        MoneyDto balanceBefore,
        MoneyDto balanceAfter,
        OffsetDateTime createdAt
) {


    public static TransactionDto fromTransaction(Transaction transaction) {
        return new TransactionDto(
                transaction.getId().value(),
                MoneyDto.fromMoney(transaction.getTransactionAmount()),
                transaction.getTransactionType().getDescription(),
                MoneyDto.fromMoney(transaction.getBalanceBefore()),
                MoneyDto.fromMoney(transaction.getBalanceAfter()),
                transaction.getCreatedAt()
        );
    }
}
