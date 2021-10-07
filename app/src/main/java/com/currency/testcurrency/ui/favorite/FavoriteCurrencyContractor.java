package com.currency.testcurrency.ui.favorite;

import com.currency.testcurrency.repository.local.db.Favorite;

import java.util.List;

public interface FavoriteCurrencyContractor {
    interface Presenter{
        void getFavoriteCurrencies();
    }
    interface View{
        void onFavoriteCurrencies(List<Favorite> favorites);
    }
}
