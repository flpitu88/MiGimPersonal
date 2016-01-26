package com.android.flpitu88.migimpersonal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flpitu88 on 26/01/16.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ejercicios(id integer primary key, nombre text, grupoMuscular text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ejercicios");
        db.execSQL("create table ejercicios(id integer primary key, nombre text, grupoMuscular text)");
    }
}
