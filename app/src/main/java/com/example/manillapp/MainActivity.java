package com.example.manillapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView resultado;
    EditText cantidadIngresada;
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
        cantidadIngresada = findViewById(R.id.cantidadIng);
        resultado = findViewById(R.id.resultadoConsult);


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


    public void consultar (View v) {

            int resultConsulta = 0;
            int dolar = 3200;
            int opcMoneda, caseMateriales, caseDije, caseTipoDije, caseCantidad;

        if(cantidadIngresada.getText().toString().isEmpty()){

            Toast.makeText(this,"FAVOR INGRESAR LA CANTIDAD A CONSULTAR",Toast.LENGTH_LONG).show();
        }else{

            //Guardar las posiciones que tienen los spinners
            opcMoneda = spTipoMoneda.getSelectedItemPosition();
            caseMateriales = spMateriales.getSelectedItemPosition();
            caseDije = spDije.getSelectedItemPosition();
            caseTipoDije = spTipoDije.getSelectedItemPosition();
            caseCantidad = Integer.parseInt(cantidadIngresada.getText().toString());


            switch (opcMoneda) {

                // 0 = pesos colombiandos
                // 1 = dolares

                //validar en pesos

                case 0:
                    if (((caseMateriales == 0) && (caseDije == 0)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = (caseCantidad * 100) * dolar;
                        break;

                    } else if (((caseMateriales == 0) && (caseDije == 0)) && (caseTipoDije == 2)) {
                        resultConsulta = (caseCantidad * 80) * dolar;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 0)) && (caseTipoDije == 3)) {
                        resultConsulta = (caseCantidad * 70) * dolar;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 1)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = (caseCantidad * 120) * dolar;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 1)) && (caseTipoDije == 2)) {
                        resultConsulta = (caseCantidad * 100) * dolar;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 1)) && (caseTipoDije == 3)) {
                        resultConsulta = (caseCantidad * 90) * dolar;
                        break;
                    }//
                    else if (((caseMateriales == 1) && (caseDije == 0)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = (caseCantidad * 90) * dolar;
                        break;

                    } else if (((caseMateriales == 1) && (caseDije == 0)) && (caseTipoDije == 2)) {
                        resultConsulta = (caseCantidad * 70) * dolar;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 0)) && (caseTipoDije == 3)) {
                        resultConsulta = (caseCantidad * 50) * dolar;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 1)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = (caseCantidad * 110) * dolar;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 1)) && (caseTipoDije == 2)) {
                        resultConsulta = (caseCantidad * 90) * dolar;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 1)) && (caseTipoDije == 3)) {
                        resultConsulta = (caseCantidad * 80) * dolar;
                        break;
                    }
                    //


                    //validar en dolares
                case 1:
                    if (((caseMateriales == 0) && (caseDije == 0)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = caseCantidad * 100;
                        break;

                    } else if (((caseMateriales == 0) && (caseDije == 0)) && (caseTipoDije == 2)) {
                        resultConsulta = caseCantidad * 80;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 0)) && (caseTipoDije == 3)) {
                        resultConsulta = caseCantidad * 70;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 1)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = caseCantidad * 120;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 1)) && (caseTipoDije == 2)) {
                        resultConsulta = caseCantidad * 100;
                        break;
                    } else if (((caseMateriales == 0) && (caseDije == 1)) && (caseTipoDije == 3)) {
                        resultConsulta = caseCantidad * 90;
                        break;
                    }//
                    else if (((caseMateriales == 1) && (caseDije == 0)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = caseCantidad * 90;
                        break;

                    } else if (((caseMateriales == 1) && (caseDije == 0)) && (caseTipoDije == 2)) {
                        resultConsulta = caseCantidad * 70;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 0)) && (caseTipoDije == 3)) {
                        resultConsulta = caseCantidad * 50;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 1)) &&
                            (caseTipoDije == 0 || caseTipoDije == 1)) {
                        resultConsulta = caseCantidad * 110;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 1)) && (caseTipoDije == 2)) {
                        resultConsulta = caseCantidad * 90;
                        break;
                    } else if (((caseMateriales == 1) && (caseDije == 1)) && (caseTipoDije == 3)) {
                        resultConsulta = caseCantidad * 80;
                        break;
                    }
                    //
            }
            resultado.setText("El valor de la manilla consultada es:" + resultConsulta);
        }
    }

    public void cancelar (View v){
        spMateriales.setSelection(0);
        spDije.setSelection(0);
        spTipoDije.setSelection(0);
        spTipoMoneda.setSelection(0);
        cantidadIngresada.setText("");
        resultado.setText("");
    }

   /* public boolean validar(){

        if(cantidadIngresada.getText().toString().isEmpty()){
                cantidadIngresada.setError("Favor ingresar la cantidad");
                cantidadIngresada.requestFocus();
            return false;
        }
        return false;
    }*/
}
