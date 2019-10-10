package com.evn.bookstore.module.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.evn.bookstore.R;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.User;

public class SignInActivity extends AppCompatActivity {
    private SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInPresenter = new SignInPresenter();

        signInPresenter.doSignIn(new SignInPresenter.SignInResponseListener() {
            @Override
            public void onSignInSuccess(BaseResponse<User> data) {

            }

            @Override
            public void onSignFail(Throwable t) {

            }
        });
    }
}
