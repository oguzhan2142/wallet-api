package com.oguzhan.wallet.api.requests;

import com.oguzhan.wallet.application.usecase.wallet.createwallet.CreateWalletCommand;
import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateWalletRequest(@NotNull UUID userId, @NotBlank String currency) {

    public CreateWalletCommand toCommand() {
        return new CreateWalletCommand(new Currency(currency), new UserId(userId));
    }
}

