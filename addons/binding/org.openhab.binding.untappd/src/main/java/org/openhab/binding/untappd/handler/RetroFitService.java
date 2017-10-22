package org.openhab.binding.untappd.handler;

import org.openhab.binding.untappd.UntappdService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitService {

    public static UntappdService getUntappdService() {
        Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")
                .registerTypeAdapter(Integer.class, new IntegerTypeAdapter())
                .registerTypeAdapterFactory(new ObjectCheckTypeAdapterFactory()).create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.untappd.com/").client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        UntappdService service = retrofit.create(UntappdService.class);
        return service;
    }

}
