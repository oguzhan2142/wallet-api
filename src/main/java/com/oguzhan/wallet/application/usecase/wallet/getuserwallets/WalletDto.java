package com.oguzhan.wallet.application.usecase.wallet.getuserwallets;


import com.oguzhan.wallet.domain.wallet.Wallet;

import java.math.BigDecimal;

public record WalletDto(String currency, BigDecimal balance) {

    public static WalletDto fromWallet(Wallet wallet) {
        return new WalletDto(wallet.getAmount().currency().value(), wallet.getAmount().amount());
    }
}
