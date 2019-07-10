package com.example.manillapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String opcMateriales[],opcDije[],opcTipoDije[],opcTipoMoneda[],opcCantidad[];
    Spinner spMateriales,spDije,spTipoDije,spTipoMoneda,spCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Captura de los objetos utilizados del spinner
        spMateriales = findViewById((R.id.material));
        spDije = findViewById((R.id.dije));
        spTipoDije = findViewById(R.id.tipoDije);
        spTipoMoneda = findViewById(R.id.tipoMoneda);
        spCantidad = findViewById(R.id.cantidad);


        //Traemos las opciones de un array Strings (valores del spinner)
        opcMateriales = getResources().getStringArray(R.array.material);
        opcDije = getResources().getStringArray(R.array.dije);
        opcTipoDije = getResources().getStringArray(R.array.tipoDije);
        opcTipoMoneda = getResources().getStringArray(R.array.tipoMoneda);
        opcCantidad = getResources().getStringArray(R.array.cantidadManilla);

        //Creamos el Adapter indicando, donde se va a colocar, como se va a visualizar y que se va a mostrar.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcMateriales);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcDije);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcTipoDije);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcTipoMoneda);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcCantidad);

        //pasamos el adapter al adapter
        spMateriales.setAdapter(adapter);
        spDije.setAdapter(adapter2);
        spTipoDije.setAdapter(adapter3);
        spTipoMoneda.setAdapter(adapter4);
        spCantidad.setAdapter(adapter5);

    }
}
