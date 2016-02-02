package com.android.flpitu88.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flpitu88 on 01/02/16.
 */
public class EjercitacionDBHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "ejercitacionDB" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    // Tablas
    protected static String TablaEjercitaciones = "ejercitacion";

    // Sentencias para crear tablas
    private String SQLCreateEjercitaciones = "CREATE TABLE " + TablaEjercitaciones +  " (id INT, ejercicio INT, series INT, repeticion INT, peso INT, estado VARCHAR(45), fecha DATE, observaciones VARCHAR(200) )";

    public EjercitacionDBHelper(Context context){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateEjercitaciones);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ejercitacion");
        db.execSQL(SQLCreateEjercitaciones);
    }
}
