package com.example.keabankapp.InternetConnectivity;

import android.os.AsyncTask;
import android.util.Log;

import com.example.keabankapp.Model.Accounts;
import com.example.keabankapp.Model.Transactions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ServerGetRequest  extends AsyncTask<String, String, String> {
    private String TAG = "ServerGetRequest";
    private String Url;

    private ServerGetRequest(String Url){
        this.Url = Url;

    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }


    public ArrayList<Accounts> getAllAccountObjects(){
        ArrayList<Accounts> accountName = new ArrayList<>();

        try{
            String response = execute("/getAccounts?Email=" + Url).get();

            Log.d(TAG, "getAllAccountObjects: " + response.length());
            JSONObject myJsonResponse = new JSONObject(response);
            JSONArray jsonArray = myJsonResponse.getJSONArray("accountsList");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject innerJsonObject = jsonArray.getJSONObject(i);
                String account = innerJsonObject.getString("account");
                double currentDeposit = innerJsonObject.getDouble("currentdeposit");
                String accountType = innerJsonObject.getString("accounttype");
                Long accountNumber = innerJsonObject.getLong("accountnumber");
                Long registrationNumber = innerJsonObject.getLong("registrationnumber");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return accountName;
    }


    public ArrayList<Transactions> getAllTransActions(){
        ArrayList<Transactions> transactionsArrayList = new ArrayList<>();
            try{
                String response = execute(Url).get();

                Log.d(TAG, response);
                JSONObject myJSONTransActions = new JSONObject(response);
                JSONArray transActions = myJSONTransActions.getJSONArray("transactions");

            for (int i = 0; i < transActions.length(); i++){
                JSONObject innerJsonObject = transActions.getJSONObject(i);
                String transactionName = innerJsonObject.getString("transactionName");
                double depositAfterTransaction = innerJsonObject.getDouble("depositAfterTransAction");
                String transActionAmount = innerJsonObject.getString("transactionAmount");
                String date = innerJsonObject.getString("date");
                boolean sendingOrRecieving = innerJsonObject.getBoolean("sendingOrRecieving");
                String doubleToString;
                if(!sendingOrRecieving){
                    doubleToString = "+" + transActionAmount;
                }else{
                    doubleToString = "-" + transActionAmount;
                }
                    transactionsArrayList.add(new Transactions(transactionName,date, doubleToString,depositAfterTransaction));

            }
            }catch (JSONException je){
                je.printStackTrace();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }catch (ExecutionException ee){
                ee.printStackTrace();
            }

        return transactionsArrayList;
    }
}
