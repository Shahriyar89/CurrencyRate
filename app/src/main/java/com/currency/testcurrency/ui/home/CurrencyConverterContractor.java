package com.currency.testcurrency.ui.home;

import com.currency.testcurrency.base.BaseContractor;
import com.currency.testcurrency.ui.home.model.Result;

public interface CurrencyConverterContractor {
     interface Presenter extends BaseContractor.BasePresenter {
          void getCurrencyConverter(String from, String to, Double amount);
     }
     interface  View extends BaseContractor.BaseView {

         void onConverterResult(Result result);
     }
}
