package com.example.keabankapp.Logic;

import android.content.Context;
import android.util.Log;

import com.example.keabankapp.Model.Transactions;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SavingAndReadingFiles {
    private static String Tag="SavingAndReadingFiles";


    public static JSONArray readFileInternalStorage(Context context) {
        FileInputStream fileInputStream;

        try {

            File file = context.getFileStreamPath("myfile.txt");
            if(file == null || !file.exists()) {
                Log.d(Tag,"file doesnt exist");

                JSONArray jsonArray= new JSONArray();
                updatefile(context,jsonArray);
                return new JSONArray();
            }

            fileInputStream = context.openFileInput("myfile.txt");
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            JSONArray jsonArray= new JSONArray(bufferedReader.readLine());
            Log.d(Tag,jsonArray.toString() + "<---reading JsonArray");


            return jsonArray;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }


    public static void saveToFile(Context context, Transactions content) {

        String filename = "myfile.txt";

        FileOutputStream outputStream;
        try {
            Gson gson = new Gson();
            JSONObject myJsonTransActions = new JSONObject(gson.toJson(content));

            JSONArray jsonArray= readFileInternalStorage(context);
            jsonArray.put(myJsonTransActions);

            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(jsonArray.toString().getBytes());
            outputStream.flush();
            outputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatefile (Context context, JSONArray jsonArray){

        String filename = "myfile.txt";

        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(jsonArray.toString().getBytes());
            outputStream.flush();
            outputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }








}
