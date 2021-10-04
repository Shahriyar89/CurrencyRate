package com.currency.testcurrency.converter.home.presenter;

import androidx.annotation.NonNull;

import com.currency.testcurrency.BuildConfig;
import com.currency.testcurrency.converter.home.CurrencyConverterContractor;
import com.currency.testcurrency.converter.home.model.Currency;
import com.currency.testcurrency.network.ApiCall;
import com.currency.testcurrency.network.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CurrencyConverterPresenter implements CurrencyConverterContractor.Presenter {
    private CurrencyConverterContractor.View view;

    public void setView(CurrencyConverterContractor.View view) {
        this.view = view;

    }

    @Override
    public void getCurrencyConverter(String from, String to, Double amount) {
        HashMap<String,Object > queryMap= new HashMap<>();
        queryMap.put("api_key" ,BuildConfig.API_KEY);
        queryMap.put("from",from);
        queryMap.put("to",to);
        queryMap.put("amount",amount);
        view.showProgress();
        ApiCall apiCall = RetrofitClient.getInstance().create(ApiCall.class);
        Observable<CurrencyResponse> observable = apiCall.getConvertCurrency(queryMap).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<CurrencyResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CurrencyResponse response) {
              view.onConverterResult(response.result);
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
