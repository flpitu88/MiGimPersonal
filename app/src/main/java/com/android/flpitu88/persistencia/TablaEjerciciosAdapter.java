package com.android.flpitu88.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by flpitu88 on 01/02/16.
 */
public class TablaEjerciciosAdapter {

    /**
     * Definimos contactos con el nombre de la tabla
     */
    public static final String C_TABLA = "Ejercicios";

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_COLUMNA_ID = "id";
    public static final String C_COLUMNA_NOMBRE = "nombre";
    public static final String C_COLUMNA_PARTECUERPO = "parteCuerpo";
    public static final String C_COLUMNA_IMAGEN = "imagen";

    private Context contexto;
    private EjerciciosDBHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{
            C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_PARTECUERPO, C_COLUMNA_IMAGEN
    };

    public TablaEjerciciosAdapter(Context context) {
        this.contexto = context;
    }

    public TablaEjerciciosAdapter abrir() throws SQLException {
        dbHelper = new EjerciciosDBHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbHelper.close();
    }

    /**
     * Devuelve cursor con todos las columnas de la tabla
     */
    public Cursor getCursor() throws SQLException {
        Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);

        return c;
    }
}
