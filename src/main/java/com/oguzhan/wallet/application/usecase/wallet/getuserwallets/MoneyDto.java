package com.oguzhan.wallet.application.usecase.wallet.getuserwallets;

import com.oguzhan.wallet.domain.wallet.Money;

import java.math.BigDecimal;

public record MoneyDto(String currency, BigDecimal amount) {

    public static MoneyDto fromMoney(Money money) {
        return new MoneyDto(money.currency().value(), money.amount());
    }

}
