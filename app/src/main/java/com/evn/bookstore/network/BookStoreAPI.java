package com.evn.bookstore.network;

import com.evn.bookstore.network.service.ProductService;
import com.evn.bookstore.network.service.UserService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookStoreAPI {
    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new BSIntercepter()) // This is used to add ApplicationInterceptor.
            .build();


    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.173.26.186:8000/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static UserService getUserService() {
        return retrofit.create(UserService.class);
    }

    public static ProductService getProductService() {
        return retrofit.create(ProductService.class);
    }
}