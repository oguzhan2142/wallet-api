package com.oguzhan.wallet.application.usecase.wallet.getbalance;

import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.domain.user.UserRepository;


public class GetBalanceUseCase implements UseCase<GetBalanceQuery, BalanceDto> {




    @Override
    public BalanceDto handle(GetBalanceQuery getBalanceQuery) {
        return null;
    }
}
