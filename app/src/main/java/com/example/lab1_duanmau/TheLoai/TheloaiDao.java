package com.example.lab1_duanmau.TheLoai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_duanmau.model.DatabaseHelper;
import com.example.lab1_duanmau.model.Theloai;

import java.util.ArrayList;
import java.util.List;

public class TheloaiDao {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    public static final String TABLE_NAME = "TheLoai";
    public static final String SQL_THE_LOAI = "CREATE TABLE TheLoai (matheloai text primary key, tentheloai text, mota text, vitri text);";
    public static final  String TAG = "TheloaiDao";
    public TheloaiDao(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertTheLoai(Theloai theloai) {
        ContentValues values = new ContentValues();
        values.put("matheloai", theloai.getMaTheLoai());
        values.put("tentheloai", theloai.getTenTheLoai());
        values.put("mota", theloai.getMoTa());
        values.put("vitri", theloai.getViTri());
            try {
                if (db.insert(TABLE_NAME, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
            return 1;
        }

        public List<Theloai> getAllTheLoai () {
            List<Theloai> dsTheLoai = new ArrayList<>();
            Cursor cus = db.query(TABLE_NAME, null, null, null, null, null, null);
            cus.moveToFirst();
            while (cus.isAfterLast() == false) {
                Theloai ee = new Theloai();
                ee.setMaTheLoai(cus.getString(0));
                ee.setTenTheLoai(cus.getString(1));
                ee.setMoTa(cus.getString(2));
                ee.setViTri(cus.getString(3));
                dsTheLoai.add(ee);
                Log.d("//====", ee.toString());
                cus.moveToNext();

            }
            cus.close();
            return dsTheLoai;
        }
        //update
        public int updateTheLoai (String matheloai, String a, String b, String c, String d){
            ContentValues values = new ContentValues();
            values.put("matheloai", a);
            values.put("tentheloai", b);
            values.put("mota", c);
            values.put("vitri", d);
            int result = db.update(TABLE_NAME, values, "matheloai=?", new String[]{matheloai});
            if (result == 0) {
                return -1;
            }
            return 1;
        }

        //delete
        public int deleteTheLoaiByID (String matheloai){
            int result = db.delete(TABLE_NAME, "matheloai=?", new String[]{matheloai});
            if (result == 0)
                return -1;
            return -1;
        }
}

