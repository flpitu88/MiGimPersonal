package com.android.flpitu88.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flpitu88 on 01/02/16.
 */
public class EjerciciosDBHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "ejerciciosDB" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    // Tablas
    protected static String TablaEjercicios = "ejercicios";

    // Sentencias para crear tablas
    private String SQLCreateEjercicios = "CREATE TABLE " + TablaEjercicios +  " (id INT, nombre VARCHAR(45), parteCuerpo INT, imagen VARCHAR(250) ) ";

    public EjerciciosDBHelper(Context context){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateEjercicios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ejercicios");
        db.execSQL(SQLCreateEjercicios);
    }
}
