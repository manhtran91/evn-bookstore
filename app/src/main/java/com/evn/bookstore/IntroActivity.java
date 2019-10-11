package com.evn.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.evn.bookstore.constant.Constant;
import com.evn.bookstore.model.User;
import com.evn.bookstore.module.home.HomeActivity;
import com.evn.bookstore.module.signin.SignInActivity;
import com.evn.bookstore.module.signup.SignUpActivity;
import com.evn.bookstore.shared.SharedPrefsUtils;
import com.google.gson.Gson;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                User user = new Gson().fromJson(
                        SharedPrefsUtils.getStringPreference(
                                BookStoreApp.getApp(), Constant.Spref.KEY_USER),
                                User.class);
                if (user != null) {
                    intent = new Intent(
                            IntroActivity.this,
                            HomeActivity.class);
                } else {
                    intent = new Intent(
                            IntroActivity.this,
                            SignInActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}
