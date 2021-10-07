package com.currency.testcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.currency.testcurrency.base.BaseActivity;
import com.currency.testcurrency.ui.favorite.view.FavoriteCurrencyActivity;
import com.currency.testcurrency.ui.home.CurrencyConverterContractor;
import com.currency.testcurrency.ui.home.presenter.CurrencyConverterPresenter;
import com.currency.testcurrency.ui.home.model.Result;
import com.currency.testcurrency.repository.remote.CurrencyRateRepositoryImpl;


public class MainActivity extends BaseActivity implements CurrencyConverterContractor.View {
    ProgressBar progressBar;
    TextView resultAmount;
    EditText amount;
    Spinner fromSpinner, toSpinner;
    Context context = this;
    CurrencyConverterPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrencyRateRepositoryImpl repositoryImpl = new CurrencyRateRepositoryImpl();
        CurrencyConverterPresenter presenter = new CurrencyConverterPresenter(this, repositoryImpl, context);
        presenter.setPresenter(this, repositoryImpl, context);

        progressBar = findViewById(R.id.progressBar);
        setProgressBar(progressBar);
        Button btnConvert = findViewById(R.id.btnConvert);
        Button btnFavorites = findViewById(R.id.btnFavorites);
        fromSpinner = findViewById(R.id.spFromCurrency);
        toSpinner = findViewById(R.id.spToCurrency);
        amount = findViewById(R.id.etFrom);
        resultAmount = findViewById(R.id.tvResult);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount.getText() != null && !amount.getText().toString().equals("")) {
                    presenter.getCurrencyConverter(
                            fromSpinner.getSelectedItem().toString(),
                            toSpinner.getSelectedItem().toString(),
                            Double.parseDouble(amount.getText().toString())
                    );
                } else {
                    Toast.makeText(context, getString(R.string.input_error_message), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FavoriteCurrencyActivity.class);
                startActivity(intent);

            }
        });
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onConverterResult(Result result) {
        resultAmount.setText(Double.parseDouble(amount.getText().toString())+" " + fromSpinner.getSelectedItem() + " = "+result.getTotalResult()+ " "+toSpinner.getSelectedItem());


    }
}