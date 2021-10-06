package com.currency.testcurrency.repository;

import com.currency.testcurrency.converter.home.presenter.CurrencyResponse;
import com.currency.testcurrency.network.CurrencyServices;
import com.currency.testcurrency.network.RetrofitClient;

import java.util.HashMap;

import io.reactivex.Observable;

public class CurrencyRateRepositoryImpl implements CurrencyRateRepository{
    CurrencyServices currencyServices = RetrofitClient.getInstance().create(CurrencyServices.class);
    @Override
    public Observable<CurrencyResponse> getCurrencyRate(HashMap<String, Object> options) {
        return currencyServices.getConvertCurrency(options);
    }
}
