package com.example.mybar.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mybar.Carro;

public class DbHelper extends SQLiteOpenHelper {


    private static  int DATABASE_VERSION=1;
    private static final String DATABASE_Nombre="carros6.db";
    public static final String TABLE_CA="consesionaria";

    public DbHelper(@Nullable Context context ) {
        super(context, DATABASE_Nombre, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_CA + "(" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                               "CarID TEXT NOT NULL,"+
                               "brand TEXT NOT NULL,"+
                               "name TEXT NOT NULL,"+
                               "model TEXT NOT NULL,"+
                               "numberOfCylender TEXT NOT NULL,"+
                               "price TEXT NOT NULL,"+
                               "image TEXT)" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_CA );
        onCreate(sqLiteDatabase);
    }

    public void insertData(Data data){
         SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
          ContentValues contentValues= new ContentValues(0);
          contentValues.put("CarID",data.getCarID());
          contentValues.put("brand",data.getBrand());
          contentValues.put("name",data.getName());
          contentValues.put("model",data.getModel());
          contentValues.put("numberOfCylender",data.getNumberOfCylender());
          contentValues.put("price",data.getPrice());
          contentValues.put("image",data.getImage());
          sqLiteDatabase.insert(TABLE_CA , null,contentValues);
          Log.i("DATABASE____________________Data_____________", "Data1");

    }
    public Carro searchCar(String number){
        Carro carro=new Carro();
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c= db.rawQuery("SELECT * FROM "+ TABLE_CA + " WHERE CarID =?", new String[]{number});
        if (c.moveToLast()){
            carro.setCarID(c.getString(1));
            carro.setBrand(c.getString(2));
            carro.setName(c.getString(3));
            carro.setModel(c.getString(4));
            Log.i("DATABASE____________________cilindros_____________"+c.getString(5), "Data1");
            carro.setNumberOfCylinder(c.getString(5));
            carro.setPrice(c.getString(6));
            carro.setImage(c.getString(1));
        }else {
            Log.e("Error not fund","user can't be found or data base empty");
        }
        return carro;
    }

}
