package com.currency.testcurrency.converter.favorite;

public interface FavoriteCurrencyContractor {
    interface Presenter{
        void getCurrencyRate();
    }
    interface View{
        void onAddFavorite();
    }
}
