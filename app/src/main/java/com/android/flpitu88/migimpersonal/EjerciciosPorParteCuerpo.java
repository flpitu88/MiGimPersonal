package com.android.flpitu88.migimpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class EjerciciosPorParteCuerpo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejerciciosporpartecuerpo);
    }

    public void volverAlMenuPrincipal(View view){
        Intent i = new Intent(this, MenuPrincipl.class);
        startActivity(i);
    }

    public void ventanaDeNuevoEjercicio(View view){
        Intent i = new Intent(this, AltaEjercicio.class);
        startActivity(i);
    }

}
