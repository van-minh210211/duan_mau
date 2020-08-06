package com.example.lab1_duanmau.TheLoai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_duanmau.R;
import com.example.lab1_duanmau.model.Theloai;

public class TheloaiActivity extends AppCompatActivity {
    Button btnThemTheLoai;
    TheloaiDao theloaiDao;
    EditText edMatheloai, edTentheloai, edVitri, edMota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);
        setTitle("Thêm thể loại");
        btnThemTheLoai = (Button) findViewById(R.id.btnAddTheLoai);
        edMatheloai = (EditText) findViewById(R.id.edMaTheLoai);
        edTentheloai = (EditText) findViewById(R.id.edTenTheLoai);
        edVitri = (EditText) findViewById(R.id.edViTri);
        edMota = (EditText) findViewById(R.id.edMoTa);
    }

    public void addTheLoai(View view) {
        theloaiDao = new TheloaiDao(TheloaiActivity.this);
        Theloai theloai = new Theloai(edMatheloai.getText().toString(), edTentheloai.getText().toString(),
                edVitri.getText().toString(), edMota.getText().toString());
        if (theloaiDao.insertTheLoai(theloai) == 1) {
            Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_LONG).show();
        }
    }

    public void showTheLoai(View view) {

        finish();

    }

    public void HuyTL(View view) {
        finish();


    }
}



