package com.oguzhan.wallet.application.usecase.wallet.topup;

import com.oguzhan.wallet.application.exceptions.InvalidBalanceForTopUpException;
import com.oguzhan.wallet.application.exceptions.WalletNotFoundException;
import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.domain.transaction.*;
import com.oguzhan.wallet.domain.wallet.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;


@Service
public class TopUpUseCase implements UseCase<TopUpCommand, TransactionDto> {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public TopUpUseCase(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    @Override
    public TransactionDto handle(TopUpCommand cmd) {

        var wallet = walletRepository.findByUserIdAndAmount_Currency(cmd.walletId(), cmd.amount().currency());

        if (wallet == null) {
            throw new WalletNotFoundException(String.format("wallet not found in the %s currency", cmd.amount().currency()));
        }

        if (!cmd.amount().isPositive()) {
            throw new InvalidBalanceForTopUpException("amount must be positive value");
        }


        var currentBalance = wallet.getAmount();

        var updatedBalance = wallet.getAmount().add(cmd.amount());

        var tx = new Transaction(
                TransactionId.newId(),
                cmd.walletId(),
                TransactionType.TopUp,
                cmd.amount(),
                TransactionStatus.COMPLETED,
                currentBalance,
                updatedBalance,
                OffsetDateTime.now()
        );

        wallet.setAmount(updatedBalance);

        transactionRepository.save(tx);
        walletRepository.save(wallet);

        return TransactionDto.fromTransaction(tx);
    }
}
