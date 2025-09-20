package com.oguzhan.wallet.domain.wallet;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable
public record WalletId(@Column(name = "id") UUID value) {


    public static WalletId newId() {

        return new WalletId(UUID.randomUUID());
    }
}
