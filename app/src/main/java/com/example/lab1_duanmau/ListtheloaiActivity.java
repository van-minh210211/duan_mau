package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.lab1_duanmau.model.Theloai;
import com.example.lab1_duanmau.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListtheloaiActivity extends AppCompatActivity {
    Intent intent;

    public static List<User> dsTheloai = new ArrayList<>();
    ListView lvTheLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtheloai);
        lvTheLoai = findViewById(R.id.lvtheloai);
    }

    public void startThemTheLoai(View view)
    {
        intent = new Intent(ListtheloaiActivity.this, TheloaiActivity.class);
        startActivity(intent);
    }
}
