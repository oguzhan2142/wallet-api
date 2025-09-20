package com.oguzhan.wallet.application.usecase.wallet.createwallet;

import com.oguzhan.wallet.application.exceptions.CurrencyExistingException;
import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.WalletDto;
import com.oguzhan.wallet.domain.wallet.Wallet;
import com.oguzhan.wallet.domain.wallet.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateWalletUseCase implements UseCase<CreateWalletCommand, WalletDto> {


    private final WalletRepository walletRepository;

    public CreateWalletUseCase(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public WalletDto handle(CreateWalletCommand createWalletCommand) {


        var existingWalletWithSameCurrency = walletRepository
                .findByUserIdAndAmount_Currency(createWalletCommand.userId(), createWalletCommand.currency());


        if (existingWalletWithSameCurrency != null) {
            throw new CurrencyExistingException(String.format("User already have %s currency", existingWalletWithSameCurrency.getAmount().currency()));
        }


        var wallet = Wallet.create(createWalletCommand.currency(), createWalletCommand.userId());
        wallet = walletRepository.save(wallet);

        return WalletDto.fromWallet(wallet);
    }
}
