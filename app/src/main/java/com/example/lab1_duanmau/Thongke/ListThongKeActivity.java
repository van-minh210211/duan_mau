package com.example.lab1_duanmau.Thongke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lab1_duanmau.HoaDon.HoaDonChiTietDao;
import com.example.lab1_duanmau.R;

public class ListThongKeActivity extends AppCompatActivity {
    TextView tvNgay, tvThang, tvNam;
    HoaDonChiTietDao hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("DOANH THU");
        setContentView(R.layout.activity_list_thong_ke);
        tvNgay = (TextView) findViewById(R.id.tvThongKeNgay);
        tvThang = (TextView) findViewById(R.id.tvThongKeThang);
        tvNam = (TextView) findViewById(R.id.tvThongKeNam);
        hoaDonChiTietDAO = new HoaDonChiTietDao(this);
        tvNgay.setText("Hôm nay      : " + hoaDonChiTietDAO.getDoanhThuTheoNgay());
        tvThang.setText("Tháng này   : " + hoaDonChiTietDAO.getDoanhThuTheoThang());
        tvNam.setText("Năm này       : " + hoaDonChiTietDAO.getDoanhThuTheoNam());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}