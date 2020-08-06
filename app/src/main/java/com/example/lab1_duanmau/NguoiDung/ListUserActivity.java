package com.example.lab1_duanmau.NguoiDung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lab1_duanmau.Adapter.UserAdapter;
import com.example.lab1_duanmau.ChangePasswordActivity;
import com.example.lab1_duanmau.LoginActivity;
import com.example.lab1_duanmau.R;
import com.example.lab1_duanmau.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    public static List<User> dsNguoiDung = new ArrayList<>();
    ListView lvNguoiDung;
    UserAdapter adapter = null;
    UserDao nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        setTitle("Người Dùng");
        lvNguoiDung = (ListView) findViewById(R.id.lvNguoiDung);
        nguoiDungDAO = new UserDao(ListUserActivity.this);
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter = new UserAdapter(this, dsNguoiDung);
        lvNguoiDung.setAdapter(adapter);
        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(ListUserActivity.this, UserDialogActivity.class);
                Bundle bd = new Bundle();
                bd.putString("USERNAME", dsNguoiDung.get(i).getUserName());
                bd.putString("PHONE", dsNguoiDung.get(i).getPhone());
                bd.putString("FULLNAME", dsNguoiDung.get(i).getHoTen());
                intent.putExtras(bd);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        dsNguoiDung.clear();
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter.changeDataset(nguoiDungDAO.getAllNguoiDung());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add_user:
                Intent intent = new Intent(ListUserActivity.this,UserActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_doi_mk:
                Intent intent1 = new Intent(ListUserActivity.this, ChangePasswordActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_dang_xuat:
                SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.clear();
                edit.commit();
                Intent intent2 = new Intent(ListUserActivity.this, LoginActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}