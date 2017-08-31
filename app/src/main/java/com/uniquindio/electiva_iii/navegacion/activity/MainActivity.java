package com.uniquindio.electiva_iii.navegacion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.uniquindio.electiva_iii.navegacion.R;
import com.uniquindio.electiva_iii.navegacion.vo.Estudiante;
import com.uniquindio.electiva_iii.navegacion.vo.Salon;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static String dato_entero = "dato_entero";
    private static String dato_string = "dato_string";
    private static String dato_parcelable = "dato_parcelable";
    private Estudiante estudiante​;
    private Salon salon;
    private TextView txtTitulo;
    //Esta será la etiqueta que será usada como base para dar
    //seguimiento al comportamiento del ciclo de vida de la actividad
    private static final String MESSAGE_DEBUG="Ciclo_de_vida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTitulo = (TextView) findViewById(R.id.text_titulo);
        //se crea el estudiante
        estudiante​ = new Estudiante(new Date(System.currentTimeMillis()), "Juana Perez", true, new float[]{4.1f, 2.3f, 3.4f});
        //luego creamos el estudiante amigo
        Estudiante amigo = new Estudiante(new Date(System.currentTimeMillis()), "Pepito Perez", true, new float[]{5f, 3.3f, 1.4f});

        estudiante​.getAmigos().add(amigo);
        salon = new Salon ( 01, 50, estudiante​.getAmigos () );
        showLog("1 onCreate");

    }

    @Override
    protected void onSaveInstanceState(Bundle guardarEstado){
        super.onSaveInstanceState(guardarEstado);
        guardarEstado.putString("mensaje",txtTitulo.getText().toString());
        /*guardarEstado.putString("variable", "var");
        guardarEstado.putInt("posicion", 0);
        showLog("onSaveInstanceState");*/

    }

    @Override
    protected void onRestoreInstanceState(Bundle recEstado){
        super.onRestoreInstanceState(recEstado);
        txtTitulo.setText(recEstado.getString("mensaje"));
        /*String var = recEstado.getString("variable");
        int pos = recEstado.getInt("posicion");
        showLog("onRestoreInstanceState "+pos+" var: "+var);*/
    }


        /**
         * Muestra la ventana dos en pantalla
         * @param view control que llamó al método
         **/

    public void pasarAVentanaDos(View view) {
        //Log.v("MainActivity", "presioné el botón");
        txtTitulo.setText ( "Inicio 123" );
        Intent intent = new Intent(this, VentanaDosActivity.class);
        intent.putExtra( dato_entero, 1);
        intent.putExtra( dato_string, "cadena");
        intent.putExtra( dato_parcelable, estudiante​);
        startActivity( intent );
    }

    public void pasarAVentanaTres(View view) {
        Intent intent = new Intent(this, VentanaTresActivity.class);
        intent.putExtra ( "Salon", salon );
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String resultado = data.getExtras().getString("RESULTADO");
        if(resultCode == RESULT_OK)
            Toast.makeText(this, requestCode+" Volví a la ventana inicial"+resultado, Toast.LENGTH_LONG)
                            .show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLog("2 onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        showLog("3 onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        showLog("4 onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        showLog("5 onStop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        showLog("6 onRestart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("7 onDestroy");
    }

    /**
     * Muestra un mensaje en consola usando el log level Debug
     * @param message mensaje que se desea mostrar en la consola
     */
    public static void showLog(String message){
        Log.d(MESSAGE_DEBUG, message);
    }

}

