package com.oguzhan.wallet.api.controllers;


import com.oguzhan.wallet.api.requests.CreateWalletRequest;
import com.oguzhan.wallet.application.usecase.wallet.createwallet.CreateWalletUseCase;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.GetUserWalletsQuery;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.GetUserWalletsUseCase;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.WalletDto;
import com.oguzhan.wallet.domain.user.UserId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/wallets")
public class WalletController {

    private final GetUserWalletsUseCase getUserWalletsUseCase;
    private final CreateWalletUseCase createWalletUseCase;

    public WalletController(GetUserWalletsUseCase getUserWalletsUseCase, CreateWalletUseCase createWalletUseCase) {
        this.getUserWalletsUseCase = getUserWalletsUseCase;
        this.createWalletUseCase = createWalletUseCase;
    }


    @PostMapping()
    public ResponseEntity<WalletDto> createWallet(@RequestBody CreateWalletRequest req) {
        var wallet = createWalletUseCase.handle(req.toCommand());
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<WalletDto>> getWallets(@PathVariable UUID userId) {

        var wallets = getUserWalletsUseCase.handle(new GetUserWalletsQuery(new UserId(userId)));
        return ResponseEntity.ok(wallets);
    }


}
