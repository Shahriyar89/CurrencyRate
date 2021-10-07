package com.currency.testcurrency.ui.favorite.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.currency.DBManager;
import com.currency.testcurrency.R;
import com.currency.testcurrency.repository.local.db.Favorite;
import com.currency.testcurrency.ui.favorite.FavoriteCurrencyContractor;
import com.currency.testcurrency.ui.favorite.presenter.FavoriteCurrencyPresenter;

import org.w3c.dom.Text;

import java.util.List;

public class FavoriteCurrencyActivity extends AppCompatActivity implements FavoriteRecyclerViewAdapter.ItemClickListener, FavoriteCurrencyContractor.View {
    Context context = this;
    private DBManager dbManager;
    private FavoriteRecyclerViewAdapter adapter;
    TextView fromCurrency, toCurrency, totalResult;
    EditText inputAmount;
    RecyclerView favoriteList;
    FavoriteCurrencyPresenter presenter;
    private List<Favorite> favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_currency);
        //dbManager = new DBManager(context);
        presenter = new FavoriteCurrencyPresenter(context, this);
        presenter.getFavoriteCurrencies();
        fromCurrency = findViewById(R.id.txtFromCurrency);
        toCurrency = findViewById(R.id.txtToCurrency);
        inputAmount = findViewById(R.id.etFrom);
        totalResult = findViewById(R.id.tvResult);
        favoriteList = findViewById(R.id.favoriteCurrencyList);

        favoriteList.setLayoutManager(new LinearLayoutManager(this));
        if (!favorites.isEmpty()) {
            adapter = new FavoriteRecyclerViewAdapter(context, favorites);
            favoriteList.setAdapter(adapter);
            adapter.setClickListener(this);
        }


    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(View view, int position) {
        if (inputAmount.getText() != null && !inputAmount.getText().toString().equals("")) {
            String fromCurr = adapter.getItem(position).getFrom();
            String toCurr = adapter.getItem(position).getTo();
            Double amount = Double.parseDouble(inputAmount.getText().toString());
            Double total = amount * adapter.getItem(position).getRate();
            fromCurrency.setText(fromCurr);
            toCurrency.setText(toCurr);
            totalResult.setText(Double.parseDouble(inputAmount.getText().toString()) + " " + fromCurr + " = " + total + " " + toCurr);
        } else {
            Toast.makeText(context, getString(R.string.input_error_message), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFavoriteCurrencies(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}