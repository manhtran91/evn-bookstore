package com.evn.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.evn.bookstore.module.signin.SignInActivity;
import com.evn.bookstore.module.signup.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        MainActivity.this,
                        SignInActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}
