package com.evn.bookstore.network.service;

import com.evn.bookstore.model.Image;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface UploadService {
    @Multipart
    @POST
    Call<Image> uploadFile (@Url String url, @Part MultipartBody.Part filePart);
}
