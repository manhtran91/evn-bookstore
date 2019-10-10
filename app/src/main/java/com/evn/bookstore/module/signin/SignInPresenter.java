package com.evn.bookstore.module.signin;

import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.User;
import com.evn.bookstore.network.BSResponse;
import com.evn.bookstore.network.BookStoreAPI;

public class SignInPresenter {


    public interface SignInResponseListener {
        void onSignInSuccess(BaseResponse<User> data);
        void onSignFail(Throwable t);
    }

    public void doSignIn(final SignInResponseListener listener) {
        BookStoreAPI.getUserService().signIn()
                .enqueue(new BSResponse<BaseResponse<User>>() {
                    @Override
                    public void onData(BaseResponse<User> data) {
                        listener.onSignInSuccess(data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        listener.onSignFail(t);
                    }
                });


    }
}
