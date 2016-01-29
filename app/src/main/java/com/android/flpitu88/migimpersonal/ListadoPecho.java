package com.android.flpitu88.migimpersonal;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListadoPecho extends Activity {

    ListView listView = (ListView) findViewById(R.id.listView);

    BaseDeDatosMiGim bbdd = new BaseDeDatosMiGim(this,"miGim",null,1);

    Cursor cursor = bbdd.getEjerciciosPorParteCuerpo(1);
    startManagingCursor(cursor);

    String[] from = new String[]{"id","nombre","parteCuerpo","imagen"};
    int[] to = new int[]{R.id.text};

    SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.row, cursor, from, to);

    listView.setAdapter(cursorAdapter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pecho);
    }
}
