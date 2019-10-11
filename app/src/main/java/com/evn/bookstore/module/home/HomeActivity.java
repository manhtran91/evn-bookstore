package com.evn.bookstore.module.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.evn.bookstore.R;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.Product;
import com.evn.bookstore.network.BSResponse;
import com.evn.bookstore.network.BookStoreAPI;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        progressBar = findViewById(R.id.loading);
        recyclerView = findViewById(R.id.list);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BookStoreAPI.getProductService()
                        .getProductList()
                        .enqueue(new BSResponse<BaseResponse<List<Product>>>() {
                            @Override
                            public void onData(BaseResponse<List<Product>> response) {
                                progressBar.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                                adapter.addProduct(response.data);
                            }

                            @Override
                            public void onError(Throwable t) {
                                progressBar.setVisibility(View.GONE);
                                String a = "";
                            }
                        });
            }
        }, 3000);

    }
}
