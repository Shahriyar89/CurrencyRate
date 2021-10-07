package com.currency.testcurrency.base;

public interface BaseContractor {
    interface BasePresenter{

    }
    interface BaseView{
        void showProgress();
        void dismissProgress();
        void onError(Throwable e);
    }
}
