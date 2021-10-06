package com.currency.testcurrency.ui.favorite;

public interface FavoriteCurrencyContractor {
    interface Presenter{
        void getCurrencyRate();
    }
    interface View{
        void onAddFavorite();
    }
}
