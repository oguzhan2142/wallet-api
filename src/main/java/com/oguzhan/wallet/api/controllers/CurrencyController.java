package com.oguzhan.wallet.api.controllers;


import com.oguzhan.wallet.application.usecase.currency.getcurrencies.GetCurrenciesQuery;
import com.oguzhan.wallet.application.usecase.currency.getcurrencies.GetCurrenciesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/currencies")
public class CurrencyController {

    private final GetCurrenciesUseCase getCurrenciesUseCase;

    public CurrencyController(GetCurrenciesUseCase getCurrenciesUseCase) {
        this.getCurrenciesUseCase = getCurrenciesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<String>> getCurrencies() {


        var models = getCurrenciesUseCase.handle(new GetCurrenciesQuery());

        return ResponseEntity.ok(models);
    }
}
