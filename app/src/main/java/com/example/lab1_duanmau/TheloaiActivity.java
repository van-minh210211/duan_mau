package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_duanmau.model.Theloai;

public class TheloaiActivity extends  AppCompatActivity {
    Button btnThemTheLoai;
    EditText edName, edMT,edvitri,edtentheloai;
    TheloaiDao theloaiDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);
        setTitle("Them The Loai");
        btnThemTheLoai = (Button) findViewById(R.id.btnAddTheLoai);
        edName = (EditText) findViewById(R.id.edMaTheLoai);
        edMT = (EditText) findViewById(R.id.edMoTa);
        edvitri = (EditText) findViewById(R.id.edViTri);
        edtentheloai = (EditText) findViewById(R.id.edTenTheLoai);
    }
    public void addUser(View view)
    {
        theloaiDao = new TheloaiDao(TheloaiActivity.this);
        Theloai TheLoai = new Theloai(edName.getText().toString(),edMT.getText().toString(),edvitri.getText().toString(),edtentheloai.getText().toString());
        if(theloaiDao.insertTheLoai(TheLoai)==1)
        {
            Toast.makeText(getApplicationContext(),"Them thanh cong",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Them that bai",Toast.LENGTH_LONG).show();
        }
    }
    public void Showtheloai( View view){
        Intent intent = new Intent(TheloaiActivity.this, ListtheloaiActivity.class);
        startActivity(intent);
    }

}
