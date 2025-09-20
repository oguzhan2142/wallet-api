package com.oguzhan.wallet.application.usecase.wallet.createwallet;

import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Currency;

public record CreateWalletCommand(Currency currency, UserId userId) {
}
