package com.currency.testcurrency.repository.remote;

import com.currency.testcurrency.ui.home.presenter.CurrencyResponse;

import java.util.HashMap;

import io.reactivex.Observable;

public interface CurrencyRateRepository {
    Observable<CurrencyResponse> getCurrencyRate(HashMap<String, Object> options);
}
