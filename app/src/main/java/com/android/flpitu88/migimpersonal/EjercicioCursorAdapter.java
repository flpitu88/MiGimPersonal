package com.android.flpitu88.migimpersonal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by flpitu88 on 29/01/16.
 */
public class EjercicioCursorAdapter extends CursorAdapter{

    private BaseDeDatosMiGim db = null;

    public EjercicioCursorAdapter(Context context, Cursor c){
        super(context,c);
        db = new BaseDeDatosMiGim(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view ;
        tv.setText(cursor.getString(cursor.getColumnIndex(BaseDeDatosMiGim.TablaEjercicios.ID)));
    }
}
