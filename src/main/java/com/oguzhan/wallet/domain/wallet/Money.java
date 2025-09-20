package com.oguzhan.wallet.domain.wallet;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Money(
        @Column(name = "currency", nullable = false)
        Currency currency,
        @Column(name = "amount", precision = 19, scale = 4, nullable = false)
        BigDecimal amount
) {


    public static Money zero(Currency currency) {
        return new Money(currency, BigDecimal.ZERO);
    }

}
