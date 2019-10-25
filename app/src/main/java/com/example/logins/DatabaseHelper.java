package com.example.logins;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.logins.DataMahasiswa.*;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="dataMahasiswa.db";
    public static final int DAATABASE_VERSION =1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DAATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final  String SQL_DATA_MAHASISWA = "CREATE TABLE " +
                dataMahasiswa.TABLE_NAME + " (" +
                dataMahasiswa.COLUMN_NIM + " TEXT NOT NULL PRIMARY KEY, " +
                dataMahasiswa.COLUMN_NAMA + " TEXT NOT NULL, " +
                dataMahasiswa.COLUMN_EMAIL + " TEXT NOT NULL" +
                ")";
        db.execSQL(SQL_DATA_MAHASISWA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + dataMahasiswa.COLUMN_NIM);
        onCreate(db);
    }
}
