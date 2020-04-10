package com.example.keabankapp.InternetConnectivity;

public class GetServerIp {
    private String ip;

    public static final GetServerIp ourInstance = new GetServerIp("192.168.31.249");

    public static String getInstance(){return ourInstance.ip;}

    private GetServerIp(String ip){
        this.ip = ip;
    }
}
