package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre = (EditText) findViewById(R.id.et1);
        et_datos = (EditText) findViewById(R.id.et2);

    }
    public void Guardar(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "El contacto se ha guardado correctamente", Toast.LENGTH_SHORT).show();

    }
    public void Buscar(View view){
        String nombre = et_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda",  MODE_PRIVATE);
                String datos = preferencias.getString(nombre, "");

                if(datos.length() == 0){
                    Toast.makeText(this, "No se encontro ningún registro", Toast.LENGTH_SHORT).show();
                }else{
                   et_datos.setText(datos);
                }
    }


}