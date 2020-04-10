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

public class Menu extends AppCompatActivity implements View.OnClickListener{
String Tag = "Menu Class";
CardView myaccount, Accounts, currency, TransferMoney, Bankinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

        currency.setOnClickListener(this);
        Accounts.setOnClickListener(this);
        myaccount.setOnClickListener(this);
        TransferMoney.setOnClickListener(this);
        Bankinfo.setOnClickListener(this);

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
                Intent moneyT = new Intent(this, TransferMoneyMenu.class);
                startActivity(moneyT);
                break;


            case R.id.Bankinfo:
                Intent bankinfo = new Intent(this, BankInfo.class);
                startActivity(bankinfo);
                break;
        }
    }



    private void init() {
        myaccount=findViewById(R.id.myaccount);
        Accounts=findViewById(R.id.accounts);
        currency=findViewById(R.id.currency);
        TransferMoney=findViewById(R.id.moneytransfer);
        Bankinfo=findViewById(R.id.Bankinfo);
    }



}