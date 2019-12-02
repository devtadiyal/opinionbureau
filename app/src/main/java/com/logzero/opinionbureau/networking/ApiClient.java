package com.logzero.opinionbureau.networking;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://devserver/AppOBApi/user/";
    public static String message = "OK";
    private static Retrofit retrofit;
    private static ApiClient mInstance = null;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();


    public static Retrofit getClient() {
        message = "OK";
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        httpClient.addNetworkInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            Response response = chain.proceed(request);
            message = response.message();
            return response;
        });

        if (retrofit == null) {

            httpClient.readTimeout(45, TimeUnit.SECONDS)
                    .connectTimeout(45, TimeUnit.SECONDS);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    public static Retrofit getSaffronClient() {
        message = "OK";
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        httpClient.addNetworkInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            Response response = chain.proceed(request);
            message = response.message();
            return response;
        });

        httpClient.readTimeout(45, TimeUnit.SECONDS)
                .connectTimeout(45, TimeUnit.SECONDS);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl("http://hq-demand.projectdevelopment.co/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }


    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}