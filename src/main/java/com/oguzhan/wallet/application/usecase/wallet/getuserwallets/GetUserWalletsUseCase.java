package com.oguzhan.wallet.application.usecase.wallet.getuserwallets;

import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.domain.wallet.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetUserWalletsUseCase implements UseCase<GetUserWalletsQuery, List<WalletDto>> {

    private final WalletRepository walletRepository;

    public GetUserWalletsUseCase(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Override
    public List<WalletDto> handle(GetUserWalletsQuery getUserWalletsQuery) {
        var wallets = walletRepository.findByUserId(getUserWalletsQuery.userId());

        return wallets.stream()
                .map(WalletDto::fromWallet)
                .toList();
    }
}
