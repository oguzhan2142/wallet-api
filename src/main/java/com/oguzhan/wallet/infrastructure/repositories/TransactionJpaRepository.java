package com.oguzhan.wallet.infrastructure.repositories;

import com.oguzhan.wallet.domain.transaction.Transaction;
import com.oguzhan.wallet.domain.transaction.TransactionId;
import com.oguzhan.wallet.domain.transaction.TransactionRepository;
import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransactionJpaRepository extends JpaRepository<Transaction, TransactionId>, TransactionRepository {

    @Query("select sum(t.transactionAmount.amount) from Transaction t " +
            "where t.userId = :user_id and t.transactionAmount.currency = :currency")
    @Override
    BigDecimal sumUserBalance(@Param("user_id") UserId userId, @Param("currency") Currency currency);
}
