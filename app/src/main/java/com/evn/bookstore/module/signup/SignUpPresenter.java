package com.evn.bookstore.module.signup;

import com.evn.bookstore.BookStoreApp;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.constant.Constant;
import com.evn.bookstore.model.User;
import com.evn.bookstore.network.BSResponse;
import com.evn.bookstore.network.BookStoreAPI;
import com.evn.bookstore.shared.SharedPrefsUtils;
import com.evn.bookstore.shared.UserRequestBody;

public class SignUpPresenter {
    public interface SignUpResponseListener {
        void onSignUpSuccess(BaseResponse<User> data);
        void onSignUpFail(Throwable t);
    }

    public void doSignUp(String phone, String password, String dispayName,
                         final SignUpResponseListener listener) {
        if (phone.isEmpty() || password.isEmpty()) {
            return;
        }
        BookStoreAPI.getUserService()
                .signUp(UserRequestBody.buildSignUpRequestBody(phone, password,dispayName))
                .enqueue(new BSResponse<BaseResponse<User>>() {
                    @Override
                    public void onData(BaseResponse<User> response) {
                        SharedPrefsUtils.setStringPreference(BookStoreApp.getApp(),
                                Constant.Spref.KEY_TOKEN, response.data.token);

                        listener.onSignUpSuccess(response);
                    }

                    @Override
                    public void onError(Throwable t) {
                        listener.onSignUpFail(t);
                    }
                });


    }
}
