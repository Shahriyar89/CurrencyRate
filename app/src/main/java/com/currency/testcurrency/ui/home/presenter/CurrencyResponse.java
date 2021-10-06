package com.currency.testcurrency.ui.home.presenter;

import com.google.gson.annotations.SerializedName;

public class CurrencyResponse {
    @SerializedName("base")
    public String base;
    @SerializedName("amount")
    public int amount;
    @SerializedName("result")
    public Result result;
    @SerializedName("ms")
    public int ms;
}
