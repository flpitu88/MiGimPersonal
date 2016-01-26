package com.android.flpitu88.migimpersonal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flpitu88 on 26/01/16.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    private static String name = "miGim";
    private static int version = 1;
    private static CursorFactory cursorFactory = null;
    
    // Tablas
    protected static String TablaEjercicios = "ejercicios";
    protected static String TablaEjercitaciones = "ejercitacion";
    protected static String TablaGruposMusculares = "parteCuerpo";

    // Sentencias para crear tablas
    private String SQLCreateEjercicios = "CREATE TABLE " + TablaEjercicios +  " (id INT, nombre VARCHAR(45), parteCuerpo INT, imagen VARCHAR(250) ) ";
    private String SQLCreateEjercitaciones = "CREATE TABLE " + TablaEjercitaciones +  " (id INT, ejercicio INT, series INT, repeticion INT, peso INT, estado VARCHAR(45), fecha DATE, observaciones VARCHAR(200) )";
    private String SQLCreateGruposMusc = "CREATE TABLE " + TablaGruposMusculares + " (id INT, nombre VARCHAR(25) )";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateEjercicios);
        db.execSQL(SQLCreateEjercitaciones);
        db.execSQL(SQLCreateGruposMusc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ejercicios");
        db.execSQL("create table ejercicios(id integer primary key, nombre text, grupoMuscular text)");
    }
    
    // ABM DE GRUPOS MUSCULARES
    
    // ABM DE EJERCICIOS
    public void agregarEjercicio(int id, String nombre, int parteCuerpo, String imagen){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO " + TablaEjercicios + 
                " (id, nombre, parteCuerpo, imagen) " +
                " VALUES(" + id + ", '" + nombre + "', '" + parteCuerpo + "', '" + imagen "' ) ");
            db.close();   
        }
    }
    
    public Cursor leerEjercicios(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT id, nombre, parteCuerpo, imagen "+
                " FROM "+TablaEjercicios, null);
    }
    
    public void eliminarEjercicio(int id){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("DELETE FROM " + TablaEjercicios + 
            "WHERE id = " + id);
        db.close();
        }
    }
    
    // ABM DE EJERCITACIONES
    // http://www.nosinmiubuntu.com/como-guardar-datos-en-android-bases-de/
    // http://www.nosinmiubuntu.com/rellenar-un-listview-con-sqlite/
    
}
