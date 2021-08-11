package iss.workshop.telemedicine_kat.Remote;

import iss.workshop.telemedicine_kat.Remote.Service.MethodCallAPI;

public class APIUtils {

    private APIUtils(){}

    //192.168.10.106  is my local host
    public static final String BASE_URL = "http://192.168.10.106:8080/"; //my ip address
    //public static final String API_URL = "http://10.0.2.2:8080/"; //for emulator

    public static MethodCallAPI getMethodCallAPI(){
        return RetrofitClient.getClient(BASE_URL).create(MethodCallAPI.class);
    }

}
