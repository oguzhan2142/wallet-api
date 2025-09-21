package com.oguzhan.wallet.api.controllers;


import com.oguzhan.wallet.api.requests.CreateWalletRequest;
import com.oguzhan.wallet.api.requests.TopUpRequest;
import com.oguzhan.wallet.application.usecase.wallet.createwallet.CreateWalletUseCase;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.GetUserWalletsQuery;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.GetUserWalletsUseCase;
import com.oguzhan.wallet.application.usecase.wallet.getuserwallets.WalletDto;
import com.oguzhan.wallet.application.usecase.wallet.topup.TopUpUseCase;

import com.oguzhan.wallet.application.usecase.wallet.topup.TransactionDto;
import com.oguzhan.wallet.domain.user.UserId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/wallets")
public class WalletController {

    private final GetUserWalletsUseCase getUserWalletsUseCase;
    private final CreateWalletUseCase createWalletUseCase;
    private final TopUpUseCase topUpUseCase;


    public WalletController(GetUserWalletsUseCase getUserWalletsUseCase, CreateWalletUseCase createWalletUseCase, TopUpUseCase topUpUseCase) {
        this.getUserWalletsUseCase = getUserWalletsUseCase;
        this.createWalletUseCase = createWalletUseCase;
        this.topUpUseCase = topUpUseCase;
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


    @PostMapping("top-up")
    public ResponseEntity<TransactionDto> topUp(@RequestBody TopUpRequest req) {
        var tx = topUpUseCase.handle(req.toCommand(UUID.randomUUID()));
        return ResponseEntity.ok(tx);
    }


}
