package com.android.flpitu88.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flpitu88 on 01/02/16.
 */
public class GrupoMuscularDBHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "grupoMuscular" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    // Tablas
    protected static String TablaGruposMusculares = "parteCuerpo";

    // Sentencias para crear tablas
    private String SQLCreateGruposMusc = "CREATE TABLE " + TablaGruposMusculares + " (id INT, nombre VARCHAR(25) )";

    public GrupoMuscularDBHelper(Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateGruposMusc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists parteCuerpo");
        db.execSQL(SQLCreateGruposMusc);
    }
}
