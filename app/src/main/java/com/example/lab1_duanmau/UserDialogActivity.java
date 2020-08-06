package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserDialogActivity extends AppCompatActivity {
    EditText edfullname, edPhone;
    UserDao nguoiDungDAO;
    String userName,fullname,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("NGƯỜI DÙNG");
        setContentView(R.layout.user_dialog);
        edfullname = findViewById(R.id.edFullName_detail);
        edPhone = findViewById(R.id.edPhone_detail);
        nguoiDungDAO = new UserDao(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        fullname = bundle.getString("FULLNAME");
        phone = bundle.getString("PHONE");
        userName = bundle.getString("USERNAME");
        edfullname.setText(fullname);
        edPhone.setText(phone);
    }

}
