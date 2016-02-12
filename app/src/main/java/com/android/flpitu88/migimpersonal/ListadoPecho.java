package com.android.flpitu88.migimpersonal;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.android.flpitu88.persistencia.EjerciciosDBHelper;
import com.android.flpitu88.persistencia.SQLControladorEjercicios;

import java.sql.SQLException;

public class ListadoPecho extends Activity{

    ListView lista;
    TextView ejer_id, ejer_nombre;
    SQLControladorEjercicios dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pecho);

        dbconeccion = new SQLControladorEjercicios(this);
        try {
            dbconeccion.abrirBaseDeDatos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lista = (ListView) findViewById(R.id.listViewPecho);

        // Tomar los datos desde la base de datos para poner en el cursor y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                EjerciciosDBHelper.EJERCICIOS_ID,
                EjerciciosDBHelper.EJERCICIOS_NOMBRE
        };
        int[] to = new int[] {
                R.id.miembro_id,
                R.id.miembro_nombre
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                ListadoPecho.this, R.layout.formato_fila_pecho, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                ejer_id = (TextView) view.findViewById(R.id.miembro_id);
                ejer_nombre = (TextView) view.findViewById(R.id.miembro_nombre);

                String aux_miembroId = ejer_id.getText().toString();
                String aux_miembroNombre = ejer_nombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), MenuPrincipl.class);
                modify_intent.putExtra("miembroId", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate

    /*private TablaEjerciciosAdapter dbAdapter;
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
    }*/

}
