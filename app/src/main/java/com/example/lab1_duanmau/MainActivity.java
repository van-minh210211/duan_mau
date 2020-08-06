package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lab1_duanmau.HoaDon.ListHoaDonActivity;
import com.example.lab1_duanmau.NguoiDung.ListUserActivity;
import com.example.lab1_duanmau.Sach.ListSachActivity;
import com.example.lab1_duanmau.TheLoai.ListtheloaiActivity;
import com.example.lab1_duanmau.Thongke.ListThongKeActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgNguoiDung, imgTheLoai, imgSach, imgHoaDon, imgTopSach, imgThongKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgNguoiDung = findViewById(R.id.viewNguoiDung);
        imgTheLoai = findViewById(R.id.viewTheLoai);
        imgSach = findViewById(R.id.viewSach);
        imgHoaDon = findViewById(R.id.viewTopSach);
        imgTopSach = findViewById(R.id.viewTopSach);
        imgThongKe = findViewById(R.id.viewThongKe);

    }


    public void ViewNguoiDung(View view) {
        Intent intent = new Intent(MainActivity.this, ListUserActivity.class);
        startActivity(intent);
    }

    public void ViewTheLoai(View view) {
        Intent intent = new Intent(MainActivity.this, ListtheloaiActivity.class);
        startActivity(intent);
    }

    public void ViewListBookActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ListSachActivity.class);
        startActivity(intent);
    }

    public void ViewListHoaDon(View view) {
        Intent intent = new Intent(MainActivity.this, ListHoaDonActivity.class);
        startActivity(intent);
    }

    public void ViewTopSach(View view) {
        Intent intent = new Intent(MainActivity.this,Sachbanchay.class);
        startActivity(intent);

    }

    public void ViewThongKeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ListThongKeActivity.class);
        startActivity(intent);
    }
}