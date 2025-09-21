package com.oguzhan.wallet.domain.transaction;

import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Currency;

import java.math.BigDecimal;

public interface TransactionRepository {


    BigDecimal sumUserBalance(UserId userId, Currency currency);

    Transaction save(Transaction transaction);


}
