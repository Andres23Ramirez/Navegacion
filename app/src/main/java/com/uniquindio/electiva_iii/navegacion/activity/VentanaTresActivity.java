package com.uniquindio.electiva_iii.navegacion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.uniquindio.electiva_iii.navegacion.R;
import com.uniquindio.electiva_iii.navegacion.vo.Estudiante;
import com.uniquindio.electiva_iii.navegacion.vo.Salon;

public class VentanaTresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_tres);

        //Se​ ​ obtiene​ ​ la​ ​ información​ ​ enviada​ ​ mediante​ ​ Bundle
        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        Salon salon​ = bundle.getParcelable("Salon");
        Log.i("Salon: ", salon​.toString ());
    }

    @Override
    public void onBackPressed() {
        Intent i = getIntent();
        i.putExtra("RESULTADO", " Info de otra actividad");
        setResult(RESULT_OK, i);
        finish();
    }
}
