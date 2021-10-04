package com.currency.testcurrency.converter.home.model;

import com.currency.testcurrency.converter.home.model.Currency;
import com.google.gson.annotations.SerializedName;

public class Root {
    @SerializedName("base")
    public String base;
    @SerializedName("results")
    public Currency results;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Currency getResults() {
        return results;
    }

    public void setResults(Currency results) {
        this.results = results;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    @SerializedName("updated")
    public String updated;
    @SerializedName("ms")
    public int ms;
}
