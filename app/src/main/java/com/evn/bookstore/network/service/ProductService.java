package com.evn.bookstore.network.service;

import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("product/list")
    Call<BaseResponse<List<Product>>> getProductList();
}
