package com.evn.bookstore.module.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.evn.bookstore.R;
import com.evn.bookstore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends
        RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> list = new ArrayList<>();

    public void addProduct(List<Product> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProductImage;
        public TextView tvProductName;
        public TextView tvProductPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            ivProductImage = itemView.findViewById(R.id.productImage);
            tvProductName = itemView.findViewById(R.id.productName);
            tvProductPrice = itemView.findViewById(R.id.productPrice);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.adapter_product, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = list.get(position);

        Picasso.get()
                .load(product.productImage)
                .into(holder.ivProductImage);

        holder.tvProductName.setText(product.productName);
        holder.tvProductPrice.setText(String.valueOf(product.price));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

}