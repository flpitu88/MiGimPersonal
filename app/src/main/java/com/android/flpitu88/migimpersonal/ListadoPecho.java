package com.android.flpitu88.migimpersonal;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.android.flpitu88.persistencia.EjercicioCursorAdapter;
import com.android.flpitu88.persistencia.TablaEjerciciosAdapter;

import java.sql.SQLException;

public class ListadoPecho extends ListActivity {

    private TablaEjerciciosAdapter dbAdapter;
    private Cursor cursor;
    private EjercicioCursorAdapter ejercicioAdapter;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pecho);

        lista = (ListView) findViewById(android.R.id.list);

        dbAdapter = new TablaEjerciciosAdapter(this);
        try {
            dbAdapter.abrir();
            consultar();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void consultar() throws SQLException {
        cursor = dbAdapter.getCursor();
        startManagingCursor(cursor);
        ejercicioAdapter = new EjercicioCursorAdapter(this, cursor);
        lista.setAdapter(ejercicioAdapter);
    }

}
