package com.currency.testcurrency.ui.home.presenter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.currency.DBManager;
import com.currency.testcurrency.repository.local.db.Favorite;
import com.currency.testcurrency.BuildConfig;
import com.currency.testcurrency.ui.home.CurrencyConverterContractor;
import com.currency.testcurrency.ui.home.model.Currency;
import com.currency.testcurrency.network.Services;
import com.currency.testcurrency.repository.remote.CurrencyRateRepository;
import com.currency.testcurrency.ui.home.model.CurrencyResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CurrencyConverterPresenter implements CurrencyConverterContractor.Presenter {
    private CurrencyConverterContractor.View view;
    private Services service;
    private CompositeDisposable disposable;
    private String API_KEY = BuildConfig.API_KEY;
    private CurrencyRateRepository repository;
    private Context context;

    public void setPresenter(CurrencyConverterContractor.View view, Services services, CurrencyRateRepository currencyRepository, Context context) {
        this.view = view;
        this.service = services;

        disposable = new CompositeDisposable();
        repository = currencyRepository;
        this.context = context;

    }

    @Override
    public void getCurrencyConverter(String from, String to, Double amount) {
        HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("api_key", API_KEY);
        queryMap.put("from", from);
        queryMap.put("to", to);
        queryMap.put("amount", amount);
        view.showProgress();
        Observable<CurrencyResponse> observable = repository.getCurrencyRate(queryMap).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<CurrencyResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CurrencyResponse response) {
                view.onConverterResult(response.result);
                DBManager dbManager = new DBManager(context);
                Favorite favorite = new Favorite(null, 1, from, to, response.result.rate);
                dbManager.insertChat(favorite);
                Log.e("heree", String.valueOf(dbManager.getFavoriteList().size()));
                view.dismissProgress();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.onError(e);
                view.dismissProgress();

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getCurrencyRate(String from, String to, Double amount) {
        view.showProgress();
        Observable<CurrencyResponse> observable = service.getCurrencyConverter(
                from, to, amount, new Services.GetCurrencyCallBack() {
                    @Override
                    public void onSuccess(CurrencyResponse currencyResponse) {
                        view.dismissProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismissProgress();
                        view.onError(e);
                    }
                });
        disposable.add((Disposable) observable);
    }


    private Double getRateForCurrency(String currency, Currency rates) {
        switch (currency) {
            case "CAD":
                return rates.cAD;
            case "HKD":
                return rates.hKD;
            case "ISK":
                return rates.iSK;
            case "EUR":
                return rates.eUR;
            case "PHP":
                return rates.pHP;
            case "DKK":
                return rates.dKK;
            case "HUF":
                return rates.hUF;
            case "CZK":
                return rates.cZK;
            case "AUD":
                return rates.aUD;
            case "RON":
                return rates.rON;
            case "SEK":
                return rates.sEK;
            case "IDR":
                return rates.iDR;
            case "INR":
                return rates.iNR;
            case "BRL":
                return rates.bRL;
            case "RUB":
                return rates.rUB;
            case "HRK":
                return rates.hRK;
            case "JPY":
                return rates.jPY;
            case "THB":
                return rates.tHB;
            case "CHF":
                return rates.cHF;
            case "SGD":
                return rates.sGD;
            case "PLN":
                return rates.pLN;
            case "BGN":
                return rates.bGN;
            case "CNY":
                return rates.cNY;
            case "NOK":
                return rates.nOK;
            case "NZD":
                return rates.nZD;
            case "ZAR":
                return rates.zAR;
            case "USD":
                return rates.uSD;
            case "MXN":
                return rates.mXN;
            case "ILS":
                return rates.iLS;
            case "GBP":
                return rates.gBP;
            case "KRW":
                return rates.kRW;
            case "MYR":
                return rates.mYR;

        }
        return null;
    }
}
