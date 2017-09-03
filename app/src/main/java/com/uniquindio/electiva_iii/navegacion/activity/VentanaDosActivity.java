package com.uniquindio.electiva_iii.navegacion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.uniquindio.electiva_iii.navegacion.R;
import com.uniquindio.electiva_iii.navegacion.vo.Estudiante;

public class VentanaDosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_dos);

        //Se​ ​ obtiene​ ​ la​ ​ información​ ​ enviada​ ​ mediante​ ​ Bundle
        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        //Se​ ​ imprime​ ​ en​ ​ el​ ​ logcat​ ​ el​ ​ entero
        int entero = bundle.getInt("dato_entero");
        Log.i("Dato entero: ", ""+entero);

        //Se​ ​ imprime​ ​ en​ ​ el​ ​ logcat​ ​ la cadena
        String cadena = bundle.getString("dato_string");
        Log.i("Dato String: ", ""+cadena);

        //Se​ ​ imprime​ ​ en​ ​ el​ ​ logcat​ ​ el​ ​ parcelable
        Estudiante estudiante​ = bundle.getParcelable("dato_parcelable");
        Log.i("Estudinate: ", estudiante​.toString());
    }
}
