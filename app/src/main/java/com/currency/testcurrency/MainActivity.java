package com.currency.testcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.currency.testcurrency.converter.home.CurrencyConverterContractor;
import com.currency.testcurrency.converter.home.presenter.CurrencyConverterPresenter;
import com.currency.testcurrency.converter.home.presenter.Result;
import com.currency.testcurrency.network.Services;
import com.currency.testcurrency.repository.CurrencyRateRepositoryImpl;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements CurrencyConverterContractor.View {
    @Inject
    public Services service;
    ProgressBar progressBar;
    TextView resultAmount;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrencyConverterPresenter presenter = new CurrencyConverterPresenter();
        CurrencyRateRepositoryImpl repositoryImpl=new CurrencyRateRepositoryImpl();
        presenter.setPresenter(this, service, repositoryImpl,context);

        progressBar = findViewById(R.id.progressBar);
        Button btnConvert = findViewById(R.id.btnConvert);
        Spinner fromSpinner = findViewById(R.id.spFromCurrency);
        Spinner toSpinner = findViewById(R.id.spToCurrency);
        EditText amount = findViewById(R.id.etFrom);
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
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable e) {
        resultAmount.setText(String.valueOf(e.getMessage()));
    }

    @Override
    public void onConverterResult(Result result) {
        resultAmount.setText(String.valueOf(result.getTotalResult()));

    }
}