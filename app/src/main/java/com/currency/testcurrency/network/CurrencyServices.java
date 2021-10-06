package com.currency.testcurrency.network;


import com.currency.testcurrency.converter.home.model.CurrencyFetchResponse;
import com.currency.testcurrency.converter.home.presenter.CurrencyResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface CurrencyServices {

    @GET("fetch-all")
    Observable<CurrencyFetchResponse> getCurrency(
            @Query("api_key") String apiKey
    );

    @GET("convert")
    Observable<CurrencyResponse> getConvertCurrency(
            @QueryMap HashMap<String, Object> options
    );
}
