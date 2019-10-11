package com.evn.bookstore.network;

import com.evn.bookstore.BookStoreApp;
import com.evn.bookstore.constant.Constant;
import com.evn.bookstore.shared.SharedPrefsUtils;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BSIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        /*String token = SharedPrefsUtils.getStringPreference(
                BookStoreApp.getApp(), Constant.Spref.KEY_TOKEN);
        if (token != null) {
            String authString = String.format("Bearer %s", token);
            Headers headers = new Headers.Builder()
                    .add("Authorization", authString)
                    .build();

            Request newRequest = originalRequest.newBuilder()
                    .headers(headers)
                    .build();

            return chain.proceed(newRequest);
        }*/

        return chain.proceed(originalRequest);

    }
}
