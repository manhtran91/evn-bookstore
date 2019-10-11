package com.evn.bookstore.module.upload;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.evn.bookstore.R;
import com.evn.bookstore.model.Image;
import com.evn.bookstore.network.BookStoreAPI;

import java.io.File;

import in.mayanknagwanshi.imagepicker.ImageSelectActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadActivity extends AppCompatActivity {
    public static final int IMAGE_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        Intent intent = new Intent(this, ImageSelectActivity.class);
        //intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, false);//default is true
        intent.putExtra(ImageSelectActivity.FLAG_CAMERA, true);//default is true
        //intent.putExtra(ImageSelectActivity.FLAG_GALLERY, true);//default is true
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String filePath = data.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH);

            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "abc.png",
                    RequestBody.create(MediaType.parse("image/*"), new File(filePath)));


            BookStoreAPI.getUploadService().uploadFile("http://10.173.26.186:3002/upload",filePart)
                    .enqueue(new Callback<Image>() {
                        @Override
                        public void onResponse(Call<Image> call, Response<Image> response) {
                            String a = "";
                        }

                        @Override
                        public void onFailure(Call<Image> call, Throwable t) {
                            String a = "";
                        }
                    });
        }
    }
}
