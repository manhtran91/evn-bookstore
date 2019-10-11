package com.evn.bookstore;

import android.app.Application;

import com.evn.bookstore.database.StudentDb;

public class BookStoreApp extends Application {
    static BookStoreApp app = null;
    static StudentDb studentDb = null;

    @Override
    public void onCreate() {
        super.onCreate();
        studentDb = new StudentDb(this);
        app = this;
    }

    public static BookStoreApp getApp() {
        return app;
    }

    public static StudentDb getStudentDb() {
        return studentDb;
    }
}
