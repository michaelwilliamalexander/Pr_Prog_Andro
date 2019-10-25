package com.example.logins;

import android.provider.BaseColumns;

public class DataMahasiswa{

    public DataMahasiswa(){

    }
    public static final class dataMahasiswa implements BaseColumns{

        public static final  String TABLE_NAME = "dataMahasiswa";
        public static final  String COLUMN_NIM = "nim";
        public static final  String COLUMN_NAMA = "nama";
        public static final  String COLUMN_EMAIL = "email";

    }
}
