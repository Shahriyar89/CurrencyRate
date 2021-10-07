package com.currency.testcurrency.ui.favorite;

import com.currency.testcurrency.base.BaseContractor;
import com.currency.testcurrency.repository.local.db.Favorite;

import java.util.List;

public interface FavoriteCurrencyContractor {
    interface Presenter extends BaseContractor.BasePresenter {
        void getFavoriteCurrencies();
    }
    interface View extends BaseContractor.BaseView {
        void onFavoriteCurrencies(List<Favorite> favorites);
    }
}
