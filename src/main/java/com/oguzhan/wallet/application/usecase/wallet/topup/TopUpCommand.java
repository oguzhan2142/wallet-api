package com.oguzhan.wallet.application.usecase.wallet.topup;

import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Money;
import com.oguzhan.wallet.domain.wallet.WalletId;

public record TopUpCommand(UserId userId, Money amount) {
}
