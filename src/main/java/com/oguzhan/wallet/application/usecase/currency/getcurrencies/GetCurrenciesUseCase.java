package com.oguzhan.wallet.application.usecase.currency.getcurrencies;

import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.domain.wallet.Currency;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class GetCurrenciesUseCase implements UseCase<GetCurrenciesQuery, List<String>> {
    @Override
    public List<String> handle(GetCurrenciesQuery getCurrenciesQuery) {
        return Currency.supportedCurrencyCodes.stream().toList();
    }
}
