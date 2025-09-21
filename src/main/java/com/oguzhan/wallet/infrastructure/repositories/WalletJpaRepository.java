package com.oguzhan.wallet.infrastructure.repositories;

import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.wallet.Wallet;
import com.oguzhan.wallet.domain.wallet.WalletId;
import com.oguzhan.wallet.domain.wallet.WalletRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletJpaRepository extends JpaRepository<Wallet, WalletId>, WalletRepository {


    List<Wallet> findByUserId(UserId userId);



}
