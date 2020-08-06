package com.example.lab1_duanmau.Sach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab1_duanmau.R;
import com.example.lab1_duanmau.TheLoai.TheloaiDao;
import com.example.lab1_duanmau.model.Sach;
import com.example.lab1_duanmau.model.Theloai;

import java.util.ArrayList;
import java.util.List;

public class SachActivity extends AppCompatActivity {
    SachDao sachDAO;
    TheloaiDao theLoaiDAO;
    Spinner spnTheLoai;
    EditText edMaSach, edTenSach, edNXB, edTacGia, edGiaBia, edSoLuong;
    String maTheLoai = "";
    List<Theloai> listTheLoai = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        setTitle("THÊM SÁCH");
        spnTheLoai = (Spinner) findViewById(R.id.spnTheLoai);
        getTheLoai();
        edMaSach = (EditText) findViewById(R.id.edMaSach);
        edTenSach = (EditText) findViewById(R.id.edTenSach);
        edNXB = (EditText) findViewById(R.id.edNXB);
        edTacGia = (EditText) findViewById(R.id.edTacGia);
        edGiaBia = (EditText) findViewById(R.id.edGiaBia);
        edSoLuong = (EditText)findViewById(R.id.edSoLuong);
//
        spnTheLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maTheLoai = listTheLoai.get(spnTheLoai.getSelectedItemPosition()).getMaTheLoai(); }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//load data into form
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edMaSach.setText(b.getString("MASACH"));
            String maTheLoai = b.getString("MATHELOAI");
            edTenSach.setText(b.getString("TENSACH"));
            edNXB.setText(b.getString("NXB"));
            edTacGia.setText(b.getString("TACGIA"));
            edGiaBia.setText(b.getString("GIABIA"));
            edSoLuong.setText(b.getString("SOLUONG"));
            spnTheLoai.setSelection(checkPositionTheLoai(maTheLoai));
        }
    }
    public void showSpinner(View view){
        sachDAO = new SachDao(SachActivity.this);
        sachDAO.getAllSach();
    }
    public void getTheLoai(){
        theLoaiDAO = new TheloaiDao(SachActivity.this);
        listTheLoai = theLoaiDAO.getAllTheLoai();
        ArrayAdapter<Theloai> dataAdapter = new ArrayAdapter<Theloai>(this,
                android.R.layout.simple_spinner_item, listTheLoai);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTheLoai.setAdapter(dataAdapter);
    }
    public void addBook(View view){
        sachDAO = new SachDao(SachActivity.this);
        Sach sach = new
                Sach(edMaSach.getText().toString(),maTheLoai,edTenSach.getText().toString(),
                edTacGia.getText().toString(),edNXB.getText().toString(),
                Double.parseDouble(edGiaBia.getText().toString()),Integer.parseInt(edSoLuong.getText
                ().toString()));
        try {
            if (sachDAO.insertSach(sach) > 0) {
                Toast.makeText(getApplicationContext(), "Thêm thành công",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Thêm thất bại",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public void showBook(View view){
        finish();
    }
    public int checkPositionTheLoai(String strTheLoai){
        for (int i = 0; i <listTheLoai.size(); i++){
            if (strTheLoai.equals(listTheLoai.get(i).getMaTheLoai())){
                return i;
            }
        }
        return 0;
    }
}