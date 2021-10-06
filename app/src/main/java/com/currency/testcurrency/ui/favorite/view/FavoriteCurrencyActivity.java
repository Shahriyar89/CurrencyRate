package com.currency.testcurrency.ui.favorite.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.currency.DBManager;
import com.currency.testcurrency.R;

public class FavoriteCurrencyActivity extends AppCompatActivity {
    Context context = this;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_currency);
        dbManager = new DBManager(context);
        RecyclerView favoriteList = findViewById(R.id.favoriteCurrencyList);
        FavoriteRecyclerViewAdapter adapter = new FavoriteRecyclerViewAdapter(context, dbManager.getFavoriteList());
        favoriteList.setLayoutManager(new LinearLayoutManager(this));
        favoriteList.setAdapter(adapter);

    }
}