package com.android.flpitu88.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by flpitu88 on 01/02/16.
 */
public class EjerciciosDBHelper extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLA_EJERCICIOS = "ejercicios";
    public static final String EJERCICIOS_ID = "_id";
    public static final String EJERCICIOS_NOMBRE = "nombre";
    public static final String EJERCICIOS_PARTECUERPO = "parteCuerpo";
    public static final String EJERCICIOS_IMAGEN = "imagen";

    // información del a base de datos
    static final String DB_NAME = "miGim";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLA_EJERCICIOS + "(" + EJERCICIOS_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + EJERCICIOS_NOMBRE + " VARCHAR(45), "
            + EJERCICIOS_PARTECUERPO + " INT, "
            + EJERCICIOS_IMAGEN + " VARCHAR(250));";

    public EjerciciosDBHelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_EJERCICIOS);
        onCreate(db);
    }

}
