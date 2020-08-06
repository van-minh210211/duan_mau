package com.example.lab1_duanmau;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_duanmau.model.DatabaseHelper;
import com.example.lab1_duanmau.model.Theloai;

public class TheloaiDao {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;
    public static final String SQL_THE_LOAI= "CREATE TABLE TheLoai (" +
            " maTheLoai text primary key, " +
            " tenTheLoai text, " +
            " moTa text, " +
            " viTri text, " +
            ");";
    public static final String TABLE_NAME = "TheLoai";

    public TheloaiDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertTheLoai(Theloai Theloai) {
        ContentValues values = new ContentValues();
        values.put("maTheLoai", Theloai.getMaTheLoai());
        values.put("tenTheLoai", Theloai.getTenTheLoai());
        values.put("moTa", Theloai.getMoTa());
        values.put("viTri", Theloai.getViTri());
        try {
            if (db.insert(TABLE_NAME, null, values) < 0) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e("TheloaiDAO", ex.getMessage());
        }


        return 1;
    }


}

