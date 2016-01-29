package com.android.flpitu88.migimpersonal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flpitu88 on 26/01/16.
 */
public class BaseDeDatosMiGim extends SQLiteOpenHelper {

    private static String name = "miGim";
    private static int version = 1;
    private static SQLiteDatabase.CursorFactory cursorFactory = null;
    
    // Tablas
    protected static String TablaEjercicios = "ejercicios";
    protected static String TablaEjercitaciones = "ejercitacion";
    protected static String TablaGruposMusculares = "parteCuerpo";

    // Sentencias para crear tablas
    private String SQLCreateEjercicios = "CREATE TABLE " + TablaEjercicios +  " (id INT, nombre VARCHAR(45), parteCuerpo INT, imagen VARCHAR(250) ) ";
    private String SQLCreateEjercitaciones = "CREATE TABLE " + TablaEjercitaciones +  " (id INT, ejercicio INT, series INT, repeticion INT, peso INT, estado VARCHAR(45), fecha DATE, observaciones VARCHAR(200) )";
    private String SQLCreateGruposMusc = "CREATE TABLE " + TablaGruposMusculares + " (id INT, nombre VARCHAR(25) )";

    public BaseDeDatosMiGim(Context context){
        super(context,"miGim",null,1);
    }

    public BaseDeDatosMiGim(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
    
    // OBTENCION DE ULTIMOS ID DISPONIBLE
    
    public int getProximoIdEjercicio(){
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        if(db!=null){
            Cursor fila = db.rawQuery("select max(id) from " + TablaEjercicios, null);
            if (fila.moveToFirst()){
                index = Integer.parseInt(fila.getString(0)) + 1;
            }
        }
        db.close();
        return index;
    }
    
    public int getProximoIdEjercitacion(){
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        if(db!=null){
            Cursor fila = db.rawQuery("select max(id) from " + TablaEjercitaciones, null);
            if (fila.moveToFirst()){
                index = Integer.parseInt(fila.getString(0)) + 1;
            }
        }
        db.close();
        return index;
    }
    
    public int getProximoIdGrupoMuscular(){
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        if(db!=null){
            Cursor fila = db.rawQuery("select max(id) from " + TablaGruposMusculares, null);
            if (fila.moveToFirst()){
                index = Integer.parseInt(fila.getString(0)) + 1;
            }
        }
        db.close();
        return index;
    }
    
    // ABM DE GRUPOS MUSCULARES
    
    public Cursor leerGruposMusculares(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT id, nombre FROM "+TablaGruposMusculares, null);
    }
    
    // ABM DE EJERCICIOS
    
    public void agregarEjercicio(String nombre, int parteCuerpo, String imagen){
        int id = getProximoIdEjercicio();
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO " + TablaEjercicios + 
                " (id, nombre, parteCuerpo, imagen) " +
                " VALUES(" + id + ", '" + nombre + "', '" + parteCuerpo + "', '" + imagen + "' ) ");
            db.close();   
        }
    }

    public Cursor leerEjercicios(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT id, nombre, parteCuerpo, imagen FROM "+TablaEjercicios, null);
    }

    public void eliminarEjercicio(int id){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("DELETE FROM " + TablaEjercicios + 
            "WHERE id = " + id);
        db.close();
        }
    }

    public Cursor getEjerciciosPorParteCuerpo(int grupo){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT id, nombre, imagen FROM "+TablaEjercicios + " WHERE parteCuerpo= " + grupo, null);
    }
    
    // ABM DE EJERCITACIONES
    
    public void agregarEjercitacion(int ejercicio, int serie, int repeticion, int peso, 
            String estado, String observaciones){
                int id = getProximoIdEjercitacion();
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO " + TablaEjercitaciones + 
                " (id, ejercicio, series, repeticion, peso, estado, observaciones) " +
                    " VALUES(" + id + ", '" + ejercicio + "', '" + serie + "', '"  + repeticion
                    + "', '"  + peso + "', '"  + estado + "', '" + observaciones + "' ) ");
            db.close();   
        }
    }
    
    public Cursor leerEjercitaciones(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT id, ejercicio, series, repeticion, peso, estado, observaciones FROM "+TablaEjercitaciones, null);
    }
    
    // http://www.nosinmiubuntu.com/como-guardar-datos-en-android-bases-de/
    // http://www.nosinmiubuntu.com/rellenar-un-listview-con-sqlite/
    // PARA OBTENER UNA IMAGEN DESDE CAMARA O GALERIA PARA EL EJERCICIO
    // http://www.maestrosdelweb.com/curso-android-trabajando-con-imagenes/
}
