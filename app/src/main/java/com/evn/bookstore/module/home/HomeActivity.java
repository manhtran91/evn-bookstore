package com.evn.bookstore.module.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.evn.bookstore.R;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.Product;
import com.evn.bookstore.network.BSResponse;
import com.evn.bookstore.network.BookStoreAPI;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BookStoreAPI.getProductService()
                .getProductList()
                .enqueue(new BSResponse<BaseResponse<List<Product>>>() {
                    @Override
                    public void onData(BaseResponse<List<Product>> data) {
                        String a = "";
                    }

                    @Override
                    public void onError(Throwable t) {
                        String a = "";
                    }
                });
    }
}
