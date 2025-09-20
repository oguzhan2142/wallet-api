package com.oguzhan.wallet.domain.wallet;


import com.oguzhan.wallet.domain.exceptions.UnsupportedCurrencyException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Set;

@Embeddable
public record Currency(
        @Column(name = "currency")
        String value
) {

    public static final Set<String> supportedCurrencyCodes = Set.of("TRY", "USD", "EUR");




    @Override
    public String value() {
        return value;
    }

    public Currency {
        value = value.toUpperCase();

        if (!supportedCurrencyCodes.contains(value)) {

            String msg = String.format("%s is not supported", value);
            throw new UnsupportedCurrencyException(msg);
        }
    }

}
