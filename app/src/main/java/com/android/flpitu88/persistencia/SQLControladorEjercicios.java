package com.android.flpitu88.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by flpitu88 on 12/02/16.
 */
public class SQLControladorEjercicios {

        private EjerciciosDBHelper dbhelper;
        private Context ourcontext;
        private SQLiteDatabase database;

        public SQLControladorEjercicios(Context c) {
            ourcontext = c;
        }

        public SQLControladorEjercicios abrirBaseDeDatos() throws SQLException {
            dbhelper = new EjerciciosDBHelper(ourcontext);
            database = dbhelper.getWritableDatabase();
            return this;
        }

        public void cerrar() {
            dbhelper.close();
        }

        public void insertarDatos(String name) {
            ContentValues cv = new ContentValues();
            cv.put(EjerciciosDBHelper.EJERCICIOS_NOMBRE, name);
            database.insert(EjerciciosDBHelper.TABLA_EJERCICIOS, null, cv);
        }

        public Cursor leerDatos() {
            String[] todasLasColumnas = new String[] {
                    EjerciciosDBHelper.EJERCICIOS_ID,
                    EjerciciosDBHelper.EJERCICIOS_NOMBRE
                  //  EjerciciosDBHelper.EJERCICIOS_PARTECUERPO,
                   // EjerciciosDBHelper.EJERCICIOS_IMAGEN
            };
            Cursor c = database.query(EjerciciosDBHelper.TABLA_EJERCICIOS, todasLasColumnas, null,
                    null, null, null, null);
            if (c != null) {
                c.moveToFirst();
            }
            return c;
        }

        public int actualizarDatos(long memberID, String memberName) {
            ContentValues cvActualizar = new ContentValues();
            cvActualizar.put(EjerciciosDBHelper.EJERCICIOS_NOMBRE, memberName);
            int i = database.update(EjerciciosDBHelper.TABLA_EJERCICIOS, cvActualizar,
                    EjerciciosDBHelper.EJERCICIOS_ID + " = " + memberID, null);
            return i;
        }

        public void deleteData(long memberID) {
            database.delete(EjerciciosDBHelper.TABLA_EJERCICIOS, EjerciciosDBHelper.EJERCICIOS_ID + "="
                    + memberID, null);
        }
}
