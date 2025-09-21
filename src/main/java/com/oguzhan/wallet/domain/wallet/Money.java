package com.oguzhan.wallet.domain.wallet;


import com.oguzhan.wallet.domain.exceptions.CurrencyMismatch;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Money(

        Currency currency,
        @Column(name = "amount", precision = 19, scale = 4, nullable = false)
        BigDecimal amount
) {


    public static Money zero(Currency currency) {
        return new Money(currency, BigDecimal.ZERO);
    }

    public boolean isNegative() {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }

    public boolean isPositive() {
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public Money add(Money other) {
        if (!other.currency().equals(currency)) {
            throw new CurrencyMismatch("%s currency and %s currency cannot add each other");
        }
        return new Money(currency, amount.add(other.amount));
    }
}
