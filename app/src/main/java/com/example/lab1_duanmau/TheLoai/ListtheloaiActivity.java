package com.example.lab1_duanmau.TheLoai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lab1_duanmau.Adapter.TheloaiAdapter;
import com.example.lab1_duanmau.R;
import com.example.lab1_duanmau.model.Theloai;

import java.util.ArrayList;
import java.util.List;

public class ListtheloaiActivity extends AppCompatActivity {
    public static List<Theloai> dsTheLoai = new ArrayList<>();
    ListView lvTheLoai;
    TheloaiAdapter adapter = null;
    TheloaiDao theLoaiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("THỂ LOẠI");
        setContentView(R.layout.activity_listtheloai);
        lvTheLoai = (ListView) findViewById(R.id.lvtheloai);
        theLoaiDAO = new TheloaiDao(ListtheloaiActivity.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter = new TheloaiAdapter(this, dsTheLoai);
        lvTheLoai.setAdapter(adapter);
        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(ListtheloaiActivity.this,TheLoaiDialogActivity.class);
                Bundle b = new Bundle();
                b.putString("MATHELOAI", dsTheLoai.get(position).getMaTheLoai());
                b.putString("TENTHELOAI", dsTheLoai.get(position).getTenTheLoai());
                b.putString("MOTA", dsTheLoai.get(position).getMoTa());
                b.putString("VITRI", String.valueOf(dsTheLoai.get(position).getViTri()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_theloai, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addTheLoai:
                Intent intent = new Intent(ListtheloaiActivity.this,TheloaiActivity.class);
                startActivity(intent);
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        dsTheLoai.clear();
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter.changeDataset(dsTheLoai);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_content, menu);
        menu.setHeaderTitle("Chọn thông tin");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_ctx_edit:
                Intent intent1 = new Intent(ListtheloaiActivity.this,TheloaiActivity.class);
                startActivity(intent1);
                return(true);
            case R.id.menu_ctx_del:
                Intent intent = new Intent(ListtheloaiActivity.this,TheloaiActivity.class);
                startActivity(intent);
                return(true);
        }
        return super.onContextItemSelected(item);
    }
}