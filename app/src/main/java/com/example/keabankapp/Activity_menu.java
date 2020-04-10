package com.example.keabankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.keabankapp.Tests.BankInfo;
import com.example.keabankapp.Tests.ChooseAccount;

import java.util.Currency;

public class Activity_menu extends AppCompatActivity implements View.OnClickListener {
String TAG = "Menu Class";
CardView myAccount, Accounts, currency, TransferMoney, BankInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    init();

        currency.setOnClickListener(this);
        Accounts.setOnClickListener(this);
        myAccount.setOnClickListener(this);
        TransferMoney.setOnClickListener(this);
        BankInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myaccount:
                Intent trans = new Intent(this, Account.class);
                startActivity(trans);
                break;

            case R.id.accounts:
                Intent acc = new Intent(this, ChooseAccount.class);
                startActivity(acc);
                break;

            case R.id.currency:
                Intent curr = new Intent(this, Currency.class);
                startActivity(curr);
                break;

            case R.id.moneytransfer:
                Intent send = new Intent(this, TransferMoneyMenu.class);
                startActivity(send);
                break;

            case R.id.Bankinfo:
                Intent info = new Intent(this, BankInfo.class);
                startActivity(info);
                break;
        }
    }

    private void init(){
        myAccount = findViewById(R.id.myaccount);
        Accounts = findViewById(R.id.accounts);
        TransferMoney = findViewById(R.id.moneytransfer);
        BankInfo = findViewById(R.id.Bankinfo);
        currency = findViewById(R.id.currency);
    }



}
