package com.example.lab1_duanmau.Sach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab1_duanmau.R;

public class SachDialogActivity extends AppCompatActivity {
    EditText maSach,tenSach,tacgia,nxb,giaban,soluong;
    SachDao sachDAO;
    Spinner spnTheLoaisua;
    String masua,tensua,tacsua,nxbsua,giasua,sosua,matheloai,maSachk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT SÁCH");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.sach_dialog);
        tenSach = (EditText) findViewById(R.id.edTenSachsua);
        maSach=(EditText)findViewById(R.id.edMaSachsua);
        tacgia = (EditText) findViewById(R.id.edTacGiasua);
        nxb = (EditText) findViewById(R.id.edNXBsua);
        giaban = (EditText) findViewById(R.id.edGiaBiasua);
        soluong = (EditText) findViewById(R.id.edSoLuongsua);
        TextView text = (TextView) findViewById(R.id.text);;
        sachDAO = new SachDao(this);
        Intent in = getIntent();
        Bundle k = in.getExtras();

        maSachk = k.getString("MASACH");
        tensua = k.getString("TENSACH");
        tacsua = k.getString("TACGIA");
        nxbsua = k.getString("NXB");
        giasua = k.getString("GIABIA");
        sosua = k.getString("SOLUONG");

        maSach.setText(maSachk);
        tenSach.setText(tensua);
        tacgia.setText(tacsua);
        nxb.setText(nxbsua);
        giaban.setText(giasua);
        soluong.setText(sosua);
    }
    public void UpdateSach(View view){
        try{
            if (sachDAO.updateSach(maSachk,maSach.getText().toString(),tenSach.getText().toString(),tacgia.getText().toString(),nxb.getText().toString(),Double.parseDouble(giaban.getText().toString()),Integer.parseInt(soluong.getText().toString()))>0){
                Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Lưu thất bại",
                        Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {
            String s =giaban.getText().toString();
            String t=soluong.getText().toString();
            if (maSach.getText().length() == 0 || tenSach.getText().length() == 0
                    || tacgia.getText().length() == 0 ||nxb.getText().length()==0
                    || giaban.getText().length() == 0 || soluong.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            }
            try {
                Double.parseDouble(s);
                Integer.parseInt(t);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Kiểm tra định dạng giá bán và số lượng ", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void HuySach(View view){
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}