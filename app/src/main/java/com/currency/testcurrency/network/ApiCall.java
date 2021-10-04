package com.currency.testcurrency.network;


import com.currency.testcurrency.converter.home.model.Root;
import com.currency.testcurrency.converter.home.presenter.CurrencyResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiCall {

    @GET("fetch-all")
    Observable<Root> getCurrency(
            @Query("api_key") String apiKey
    );

    @GET("convert")
    Observable<CurrencyResponse> getConvertCurrency(
            @QueryMap HashMap<String, Object> options
    );
}
