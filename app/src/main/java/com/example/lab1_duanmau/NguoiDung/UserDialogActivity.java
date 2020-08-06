package com.example.lab1_duanmau.NguoiDung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_duanmau.R;

public class UserDialogActivity extends AppCompatActivity {
    EditText edFullName, edPhone;
    Button btn ;
    UserDao nguoiDungDAO;
    String username , fullname, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT NGƯỜI DÙNG");
        setContentView(R.layout.user_dialog);
        edFullName = (EditText) findViewById(R.id.edFullName_detail);
        edPhone = (EditText)findViewById(R.id.edPhone_detail);
        btn = findViewById(R.id.btnUpdateUser);
        nguoiDungDAO = new UserDao(this);
        Intent in = getIntent();
        Bundle bundle= in.getExtras();
        username= bundle.getString("USERNAME");
        fullname= bundle.getString("FULLNAME");
        phone= bundle.getString("PHONE");
        edFullName.setText(fullname);
        edPhone.setText(phone);

    }
    public void updateUser(View view){
        if (
                nguoiDungDAO.updateInfoNguoiDung(username, edPhone.getText().toString(),edFullName.getText().toString())>0){
            Toast.makeText(getApplicationContext(), " Sửa thành công ", Toast.LENGTH_LONG).show();

        }finish();
    }
    public  void Huy(View view){
        finish();


    }
}