package com.uniquindio.electiva_iii.navegacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

    /**
     * Muestra la ventana dos en pantalla
     * @param view control que llamó al método
     */
    public void pasarAVentanaDos(View view){
        Log.v("MainActivity","presioné el botón");
    }