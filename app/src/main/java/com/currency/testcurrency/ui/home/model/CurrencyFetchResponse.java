package com.currency.testcurrency.ui.home.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;

@Entity
public class CurrencyFetchResponse {
    @SerializedName("base")
    public String base;
    @SerializedName("results")
    public Currency results;
    @SerializedName("updated")
    public String updated;
    @SerializedName("ms")
    public int ms;
}
