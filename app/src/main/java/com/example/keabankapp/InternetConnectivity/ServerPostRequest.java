package com.example.keabankapp.InternetConnectivity;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class ServerPostRequest extends AsyncTask<String, String, Integer> {
    private String url;
    private String Tag = "ServerGetRequest";
    private Integer response;

    public ServerPostRequest(String url) {
        this.url = url;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        String ip = GetServerIp.getInstance();
        String webApiAdress = ip + url;
        Integer response = null;
        URL url;

        try{
            url = new URL(webApiAdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.connect();
            response = con.getResponseCode();
            con.disconnect();

            if(response == 200){
                return response;
            }else{
                return 401;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer execute(){
        try{
            response = execute(url).get();

        }catch(ExecutionException ee){
            ee.printStackTrace();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return response;
    }

    public Integer getResponse(){return response;}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }


}
