package com.evn.bookstore.module.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.evn.bookstore.BookStoreApp;
import com.evn.bookstore.R;
import com.evn.bookstore.database.StudentDb;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        insertStudent();

        Toast.makeText(this, getStudent(), Toast.LENGTH_SHORT).show();
    }

    void insertStudent() {
        SQLiteDatabase db = BookStoreApp.getStudentDb().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(StudentDb.FIELD_USER_ID, "123");
        values.put(StudentDb.FIELD_USER_NAME, "Ryan");

        db.insert(StudentDb.TABLE_USER, null, values);
        db.close();
    }

    String getStudent() {
        SQLiteDatabase db = BookStoreApp.getStudentDb().getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(StudentDb.TABLE_USER, new String[]{
                            StudentDb.FIELD_USER_ID,
                            StudentDb.FIELD_USER_NAME},
                    StudentDb.FIELD_USER_ID + "=?",
                    new String[]{"123"},
                    null,
                    null,
                    null,
                    null
            );
            if (cursor != null)
                cursor.moveToFirst();

            return cursor.getString(1);
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }
}
