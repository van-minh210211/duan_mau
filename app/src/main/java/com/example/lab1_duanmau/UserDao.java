package com.example.lab1_duanmau;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_duanmau.model.DatabaseHelper;
import com.example.lab1_duanmau.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (username text primary key, password text, phone text, hoten text);";
    public static final String TAG = "NguoiDungDAO";
    public UserDao(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertNguoiDung(User nguoiDung){
        ContentValues values = new ContentValues();
        values.put("username", nguoiDung.getUserName());
        values.put("password",nguoiDung.getPassword());
        values.put("phone", nguoiDung.getPhone());
        values.put("hoten",nguoiDung.getHoTen());
        try {
            if(db.insert(TABLE_NAME, null, values) == -1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }

    public List<User> getAllNguoiDung(){
        List<User> dsNguoiDung = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            User ee = new User();
            ee.setUserName(cursor.getString(0));
            ee.setPassword(cursor.getString(1));
            ee.setPhone(cursor.getString(2));
            ee.setHoTen(cursor.getString(3));
            dsNguoiDung.add(ee);
            Log.d("//====",ee.toString());
            cursor.moveToNext();
        }
        cursor.close();
        return dsNguoiDung;
    }

    public int updateNguoiDung(User nd){
        ContentValues values = new ContentValues();
        values.put("username", nd.getUserName());
        values.put("password", nd.getPassword());
        values.put("phone",nd.getPhone());
        values.put("hoten",nd.getHoTen());
        int result = db.update(TABLE_NAME,values, "username=?", new String[]{nd.getUserName()});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int changePasswordNguoiDung(User nd){
        ContentValues values = new ContentValues();
        values.put("username",nd.getUserName());
        values.put("password",nd.getPassword());
        int result = db.update(TABLE_NAME, values, "username=?", new String[]{nd.getUserName()});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int updateInfo(String username, String phone, String name){
        ContentValues values = new ContentValues();
        int result = db.update(TABLE_NAME, values, "username=?", new String[]{username});
        if (result == 0){
            return  -1;
        }
        return 1;
    }

    //DELETE
    public int deleteNguoiDungByID(String username){
        int result = db.delete(TABLE_NAME, "username=?", new String[]{username});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    //CHECK LOGIN
    public int checkLogin (String username, String password){
        int result = db.delete(TABLE_NAME, "username=? AND password=?", new String[]{username, password});
        if (result == 0){
            return -1;
        }
        return 1;
    }
}
