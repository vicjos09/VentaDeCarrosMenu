package com.example.mybar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_Nombre="agenda.db";
    public static final String TABLE_CONTACTOS="t_contactos";

    public DbHelper(@Nullable Context context ) {
        super(context, DATABASE_Nombre, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_CONTACTOS + "(" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                               "nombre TEXT NOT NULL,"+
                               "correo_electronico TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);
    }


}
