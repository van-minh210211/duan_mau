package com.example.lab1_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_duanmau.NguoiDung.UserDao;
import com.example.lab1_duanmau.model.User;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText edPass, edRePass, edUserName;
    Button btn;
    UserDao nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        edUserName = (EditText) findViewById(R.id.edReUsername_DMK);
        edPass = (EditText) findViewById(R.id.edPassword_DMK);
        edRePass = (EditText) findViewById(R.id.edRePassword_DMK);
        btn = findViewById(R.id.btnChangePass);
    }

    public int validateForm() {
        int check = 1;
        if (edPass.getText().length() == 0 || edRePass.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }

    public void changePassword(View view) {
        String strUserName = edUserName.getText().toString();
        nguoiDungDAO = new UserDao(ChangePasswordActivity.this);
        User user = new User(strUserName, edPass.getText().toString(), "",
                "");
        try {
            if (validateForm()>0){
                if (nguoiDungDAO.changePasswordNguoiDung(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Lưu thành công",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Lưu thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
            finish();
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
}



