package com.oguzhan.wallet.domain.transaction;

import com.oguzhan.wallet.domain.transaction.converters.TransactionStatusAttributeConverter;
import com.oguzhan.wallet.domain.transaction.converters.TransactionTypeAttributeConverter;
import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Money;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @EmbeddedId
    private TransactionId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_id", nullable = false, updatable = false))
    private UserId userId;

    @Convert(converter = TransactionTypeAttributeConverter.class)
    @Column(name = "transaction_type", nullable = false, length = 32, updatable = false)
    private TransactionType transactionType;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency.value", column = @Column(name = "transaction_currency", nullable = false)),
            @AttributeOverride(name = "amount", column = @Column(name = "transaction_amount", precision = 19, scale = 4, nullable = false))
    })
    private Money transactionAmount;

    @Convert(converter = TransactionStatusAttributeConverter.class)
    @Column(name = "status", length = 15, nullable = false)
    private TransactionStatus status;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency.value", column = @Column(name = "balance_before_currency", nullable = false)),
            @AttributeOverride(name = "amount", column = @Column(name = "balance_before_amount", precision = 19, scale = 4, nullable = false))
    })
    private Money balanceBefore;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency.value", column = @Column(name = "balance_after_currency", nullable = false)),
            @AttributeOverride(name = "amount", column = @Column(name = "balance_after_amount", precision = 19, scale = 4, nullable = false))
    })
    private Money balanceAfter;


    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;


    public Transaction(TransactionId id, UserId userId, TransactionType transactionType, Money transactionAmount, TransactionStatus status, Money balanceBefore, Money balanceAfter, OffsetDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.status = status;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.createdAt = createdAt;
    }

    public TransactionId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Money getTransactionAmount() {
        return transactionAmount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Money getBalanceBefore() {
        return balanceBefore;
    }

    public Money getBalanceAfter() {
        return balanceAfter;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
