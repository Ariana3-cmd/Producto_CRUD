package com.example.producto.config;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME  = "DB2022";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null ,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table productos(_id integer primary key autoincrement, "
                +"nombre text not null, precio not null, stock not null)");
        db.execSQL("insert into usuarios(nombre, precio, stock) values('papas', '1.00', '30')");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
        public static class Productos{
            public static final String TABLE = "productos";
            public static final String _ID = "_id";
            public static final String NOMBRE = "nombre";
            public static final String PRECIO = "precio";
            public static final String STOCK = "stock";
            public static final String[] COLUMNAS = new String[]{_ID, NOMBRE, PRECIO, STOCK};

        }
}
