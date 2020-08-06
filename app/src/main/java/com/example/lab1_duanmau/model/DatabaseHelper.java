package com.example.lab1_duanmau.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lab1_duanmau.HoaDon.HoaDonChiTietDao;
import com.example.lab1_duanmau.HoaDon.HoaDonDao;
import com.example.lab1_duanmau.Sach.SachDao;
import com.example.lab1_duanmau.TheLoai.TheloaiDao;
import com.example.lab1_duanmau.NguoiDung.UserDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(UserDao.SQL_NGUOI_DUNG);
        database.execSQL(TheloaiDao.SQL_THE_LOAI);
        database.execSQL(SachDao.SQL_SACH);
        database.execSQL(HoaDonDao.SQL_HOA_DON);
        database.execSQL(HoaDonChiTietDao.SQL_HOA_DON_CT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + UserDao.TABLE_NAME);
        sqLiteDatabase.execSQL("Drop table if exists " + TheloaiDao.TABLE_NAME);
        sqLiteDatabase.execSQL("Drop table if exists " + SachDao.TABLE_NAME);
        sqLiteDatabase.execSQL("Drop table if exists "+ HoaDonDao.TABLE_NAME);
        sqLiteDatabase.execSQL("Drop table if exists "+ HoaDonChiTietDao.TABLE_NAME);


        onCreate(sqLiteDatabase);
    }

}
