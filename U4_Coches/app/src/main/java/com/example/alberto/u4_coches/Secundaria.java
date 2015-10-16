package com.example.alberto.u4_coches;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Secundaria extends Activity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        spinner=(Spinner) findViewById(R.id.spinner_coches);
        Bundle bundle=getIntent().getExtras();
        String ficheiro=bundle.getString("FICHEIRO");
        String linea="";
        ArrayList<String> coches=new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(ficheiro)));
            while((linea = br.readLine()) != null){
                coches.add(linea+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coches);
        adaptador.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Posicion: "+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
