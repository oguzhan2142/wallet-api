package com.oguzhan.wallet.domain.wallet;


import com.oguzhan.wallet.domain.user.UserId;

import java.util.List;

public interface WalletRepository {


    List<Wallet> findByUserId(UserId userId);

    Wallet findByUserIdAndAmount_Currency(UserId userId, Currency currency);

    Wallet save(Wallet wallet);
}
