package com.android.flpitu88.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.android.flpitu88.migimpersonal.BaseDeDatosMiGim;

import java.sql.SQLException;

/**
 * Created by flpitu88 on 29/01/16.
 */
public class EjercicioCursorAdapter extends CursorAdapter {

    private TablaEjerciciosAdapter dbAdapter = null;

    public EjercicioCursorAdapter(Context context, Cursor c) throws SQLException {
        super(context, c);
        dbAdapter = new TablaEjerciciosAdapter(context);
        dbAdapter.abrir();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view ;
        tv.setText(cursor.getString(cursor.getColumnIndex(dbAdapter.C_COLUMNA_NOMBRE)));
    }
}
