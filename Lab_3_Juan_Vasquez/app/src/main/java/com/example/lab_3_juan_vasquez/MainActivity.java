package com.example.lab_3_juan_vasquez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText numero1,numero2;
    TextView res;
    Spinner opereaciones;
    int opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Controles();
        this.ToSpinner();



    }

    private void Controles(){
        numero1 = (EditText)findViewById(R.id.num1);
        numero2 = (EditText)findViewById(R.id.num2);

        res = (TextView)findViewById(R.id.resultado);
        opereaciones =(Spinner)findViewById(R.id.operaciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,LoadSpinner());

        opereaciones.setAdapter(adapter);
    }

    public void Ejecutar (View view){
        try{
            int n1 = Integer.parseInt(numero1.getText().toString());
            int n2 = Integer.parseInt(numero2.getText().toString());
            int resultadoe = n1 * n2;
            res.setText(Integer.toString(resultadoe));
        }
        catch (Exception e){
            Toast.makeText(this,"Error en la multiplicacion de los datos" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }





    }

    private List<String> LoadSpinner(){
        List<String> operaciones = new ArrayList<String>();
        operaciones.add("Seleccionar Operacion");
        operaciones.add("Suma");
        operaciones.add("Resta");
        operaciones.add("Multiplicacion");
        operaciones.add("Division");


        return operaciones;
    }

    private void ToSpinner(){
        opereaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String operaciones = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Operacion Seleccionada: "+operaciones,Toast.LENGTH_LONG).show();

                }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }




}

