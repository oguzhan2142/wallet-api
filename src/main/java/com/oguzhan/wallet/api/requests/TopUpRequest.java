package com.oguzhan.wallet.api.requests;

import com.oguzhan.wallet.application.usecase.wallet.topup.TopUpCommand;
import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Currency;
import com.oguzhan.wallet.domain.wallet.Money;

import java.math.BigDecimal;
import java.util.UUID;

public record TopUpRequest(String currency, BigDecimal amount) {

    public TopUpCommand toCommand(UUID userId) {
        return new TopUpCommand(new UserId(userId), new Money(new Currency(currency), amount));
    }
}
