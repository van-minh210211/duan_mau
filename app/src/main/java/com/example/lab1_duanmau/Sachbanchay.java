package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab1_duanmau.Adapter.SachAdapter;
import com.example.lab1_duanmau.Sach.SachDao;
import com.example.lab1_duanmau.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class Sachbanchay extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    SachAdapter adapter = null;
    SachDao sachDAO;
    EditText edThang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sachbanchay);
        lvBook = (ListView) findViewById(R.id.lvsachthang);
        edThang = (EditText) findViewById(R.id.ednhapthang);
    }
    public  void sachthang (View view){
        if (Integer.parseInt(edThang.getText().toString())>13|| Integer.parseInt(edThang.getText().toString())<0){
            Toast.makeText(this, "sai tháng", Toast.LENGTH_SHORT).show();
        }else {
            sachDAO= new SachDao(Sachbanchay.this);
            dsSach = sachDAO.getSachTop10(edThang.getText().toString());
            adapter = new SachAdapter(this,dsSach);
            lvBook.setAdapter(adapter);
        }
    }
}
