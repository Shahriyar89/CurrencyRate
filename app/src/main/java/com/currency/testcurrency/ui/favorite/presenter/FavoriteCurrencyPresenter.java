package com.currency.testcurrency.ui.favorite.presenter;

import android.content.Context;

import com.currency.DBManager;
import com.currency.testcurrency.ui.favorite.FavoriteCurrencyContractor;

public class FavoriteCurrencyPresenter implements FavoriteCurrencyContractor.Presenter {
    private DBManager dbManager;
    private FavoriteCurrencyContractor.View view;

    public FavoriteCurrencyPresenter(Context context, FavoriteCurrencyContractor.View view) {
        this.view = view;
        this.dbManager = new DBManager(context);
    }

    @Override
    public void getFavoriteCurrencies() {
        view.onFavoriteCurrencies(dbManager.getFavoriteList());
    }
}
