package com.example.manillapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String opcMateriales[],opcDije[],opcTipoDije[],opcTipoMoneda[];
    Spinner spMateriales,spDije,spTipoDije,spTipoMoneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Captura de los objetos utilizados del spinner
        spMateriales = findViewById((R.id.material));
        spDije = findViewById((R.id.dije));
        spTipoDije = findViewById(R.id.tipoDije);
        spTipoMoneda = findViewById(R.id.tipoMoneda);


        //Traemos las opciones de un array Strings (valores del spinner)
        opcMateriales = getResources().getStringArray(R.array.material);
        opcDije = getResources().getStringArray(R.array.dije);
        opcTipoDije = getResources().getStringArray(R.array.tipoDije);
        opcTipoMoneda = getResources().getStringArray(R.array.tipoMoneda);


        //Creamos el Adapter indicando, donde se va a colocar, como se va a visualizar y que se va a mostrar.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item_lista,opcMateriales);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,R.layout.spinner_item_lista,opcDije);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,R.layout.spinner_item_lista,opcTipoDije);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this,R.layout.spinner_item_lista,opcTipoMoneda);

        //pasamos el adapter al adapter
        spMateriales.setAdapter(adapter);
        spDije.setAdapter(adapter2);
        spTipoDije.setAdapter(adapter3);
        spTipoMoneda.setAdapter(adapter4);


    }
}
