package com.example.lab1_duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab1_duanmau.Adapter.UserAdapter;
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
        setTitle("Danh Sách Người Dùng");
        lvNguoiDung = (ListView) findViewById(R.id.lvNguoiDung);
        nguoiDungDAO = new UserDao(ListUserActivity.this);
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter = new UserAdapter(this, dsNguoiDung);
        lvNguoiDung.setAdapter(adapter);
        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DialogDetailUser();
            }
        });

    }

    public void DialogDetailUser(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.user_dialog);
        EditText edPhone = (EditText) dialog.findViewById(R.id.edPhone_detail);
        EditText edFullName = (EditText) dialog.findViewById(R.id.edFullName_detail);
        Button btnUpdateUser = (Button) dialog.findViewById(R.id.btnUpdateUser);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancelDetail);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
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
