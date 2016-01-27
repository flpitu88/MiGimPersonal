package com.android.flpitu88.migimpersonal;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AltaEjercicio extends Activity {

    private static int nro_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_ejercicio);
    }

    public void guardarEjercicio(View v){
        EditText nombreET = (EditText) findViewById(R.id.nombreEjText);
        EditText numeroET = (EditText) findViewById(R.id.nuevoEjNumero);
        BaseDeDatosMiGim bd = new BaseDeDatosMiGim(this,"miGim",null,1);
        bd.agregarEjercicio(nro_id,nombreET.getText().toString(),
                Integer.parseInt(numeroET.getText().toString()),"imagen");
        nombreET.setText("");
        numeroET.setText("");
        nro_id++;
        Toast.makeText(this, "Se guardo el ejercicio correctamente",
                Toast.LENGTH_SHORT).show();
    }

}
