package com.currency.testcurrency.ui.home.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName(value = "AZN", alternate = {"EUR", "USD", "CAD", "HKD",
            "ISK", "PHP", "DKK", "HUF", "CZK", "AUD", "RON", "SEK", "IDR", "INR", "BRL",
            "RUB", "HRK", "JPY", "THB", "CHF", "SGD", "PLN", "BGN", "CNY", "NOK", "NZD",
            "ZAR", "MXN", "ILS", "GBP", "KRW", "MYR"
    })
    private double totalResult;

    @SerializedName("rate")
    public double rate;

    public double getTotalResult() {
        return totalResult;
    }
}


