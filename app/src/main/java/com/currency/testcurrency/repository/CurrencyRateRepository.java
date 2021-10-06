package com.currency.testcurrency.repository;

import com.currency.testcurrency.converter.home.presenter.CurrencyResponse;

import java.util.HashMap;

import io.reactivex.Observable;

public interface CurrencyRateRepository {
    Observable<CurrencyResponse> getCurrencyRate(HashMap<String, Object> options);
}
