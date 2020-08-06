package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_duanmau.model.User;

public class UserActivity extends AppCompatActivity {
    Button btnThemNguoiDung;
    UserDao nguoiDungDAO;
    EditText edUser,edPass,edPhone,edFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTitle("Thêm người dùng");
        btnThemNguoiDung = (Button)findViewById(R.id.btnAddUser);
        edUser = (EditText)findViewById(R.id.edUserName);
        edPass = (EditText)findViewById(R.id.edPassword);
        edPhone = (EditText)findViewById(R.id.edPhone);
        edFullName = (EditText)findViewById(R.id.edFullName);
    }

    public void addUser(View view){
        nguoiDungDAO = new UserDao(UserActivity.this);
        User user = new User(edUser.getText().toString(),edPass.getText().toString(),
                edPhone.getText().toString(),edFullName.getText().toString());
        if(nguoiDungDAO.insertNguoiDung(user)==1)
        {
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();
        }
    }

    public void showUsers(View view)
    {

        finish();

    }


}
