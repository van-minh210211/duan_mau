package com.example.lab1_duanmau.TheLoai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_duanmau.R;

public class TheLoaiDialogActivity extends AppCompatActivity {
    EditText edMatheloai,edTentheloai,edMota,edVitri;
    TheloaiDao theloaiDAO;
    String ten,vi,mo,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT THỂ LOẠI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.the_loai_dialog);
        edMatheloai = (EditText) findViewById(R.id.edMaTheLoai_DL1);
        edTentheloai = (EditText) findViewById(R.id.edTenTheLoai_DL1);
        edMota = (EditText) findViewById(R.id.edMoTa_DL1);
        edVitri = (EditText) findViewById(R.id.edViTri_DL1);
        theloaiDAO = new TheloaiDao(this);
        Intent in = getIntent();
        Bundle c = in.getExtras();
        user=c.getString("MATHELOAI");
        ten = c.getString("TENTHELOAI");
        mo = c.getString("MOTA");
        vi = c.getString("VITRI");
        edMatheloai.setText(user);
        edTentheloai.setText(ten);
        edMota.setText(mo);
        edVitri.setText(vi);
    }
    public void updateU(View view){

        if (theloaiDAO.updateTheLoai(user,edMatheloai.getText().toString(),edTentheloai.getText().toString(),edMota.getText().toString(),edVitri.getText().toString())>0){
            Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
        }
    }
    public void Huy(View view){
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