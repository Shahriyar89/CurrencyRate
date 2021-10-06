package com.currency.testcurrency.ui.home;

import com.currency.testcurrency.ui.home.presenter.Result;

public interface CurrencyConverterContractor {
     interface Presenter {
          void getCurrencyConverter(String from, String to, Double amount);
          void  getCurrencyRate( String from, String to, Double amount);
     }
     interface  View{
         void showProgress();
         void dismissProgress();
         void onError(Throwable e);
         void onConverterResult(Result result);
     }
}
