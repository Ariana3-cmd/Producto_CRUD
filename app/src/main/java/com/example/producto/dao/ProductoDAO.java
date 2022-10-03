package com.example.producto.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.producto.config.DBHelper;
import com.example.producto.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private DBHelper helper;
    private SQLiteDatabase database;
    public ProductoDAO(Context context){
        helper = new DBHelper(context);
    }
    private SQLiteDatabase getDatabase(){
        if(database == null){
            database = helper.getWritableDatabase();
        }
        return database;
    }
    private Producto crearProducto(Cursor cursor){
        Producto producto = new Producto(
                cursor.getInt(cursor.getColumnIndex(DBHelper.Productos._ID)),
                cursor.getString(cursor.getColumnIndex(DBHelper.Productos.NOMBRE)),
                cursor.getString(cursor.getColumnIndex(DBHelper.Productos.PRECIO)),
                cursor.getString(cursor.getColumnIndex(DBHelper.Productos.STOCK))
        );
        return producto;
    }
    public List<Producto> listarProducto(){
        Cursor cursor = getDatabase().query(DBHelper.Productos.TABLE,DBHelper.Productos.COLUMNAS, null, null, null, null, null);
        List<Producto> lista = new ArrayList<Producto>();
        while(cursor.moveToNext()){
            Producto modelo = crearProducto(cursor);
            lista.add(modelo);
        }
        return lista;
    }
    public long modificarProducto(Producto producto){
        ContentValues values = new ContentValues();
        values.put(DBHelper.Productos.NOMBRE, producto.getNombre());
        values.put(DBHelper.Productos.PRECIO, producto.getPrecio());
        values.put(DBHelper.Productos.STOCK, producto.getStock());
        if(producto.get_id() != null){
            return database.update(DBHelper.Productos.TABLE, values,
                    "_id = ?", new String[]{producto.get_id().toString()});
        }
        return getDatabase().insert(DBHelper.Productos.TABLE,null,values);
    }
    public boolean eliminarProducto(int id){
        return getDatabase().delete(DBHelper.Productos.TABLE,"_id = ?", new String[]{Integer.toString(id)}) > 0;
    }
    public Producto buscarProductoPorID(int id){
        Cursor cursor = getDatabase().query(DBHelper.Productos.TABLE,
                DBHelper.Productos.COLUMNAS, "_id = ?", new String[]{ Integer.toString(id)}, null, null, null);
        if(cursor.moveToNext()){
            Producto model = crearProducto(cursor);
            cursor.close();
            return model;
        }
        return null;
    }
    public void cerrarDB(){
        helper.close();
        database = null;
    }
}
