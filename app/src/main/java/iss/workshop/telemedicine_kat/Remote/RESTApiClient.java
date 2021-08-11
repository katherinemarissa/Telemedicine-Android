package iss.workshop.telemedicine_kat.Remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class RESTApiClient {

    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(1000, TimeUnit.SECONDS)
            .readTimeout(1000, TimeUnit.SECONDS).build();
}
