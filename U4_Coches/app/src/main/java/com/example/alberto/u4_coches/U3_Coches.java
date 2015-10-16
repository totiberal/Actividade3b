package com.example.alberto.u4_coches;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class U3_Coches extends Activity {
    boolean sdDisponhible = false;
    boolean sdAccesoEscritura = false;
    File dirFicheiroSD;
    File rutaCompleta;
    RadioButton rbEngadir;
    RadioButton rbSobrescribir;
    EditText textoEditable;
    Button btnLer;
    public static String nomeFicheiro = "coches.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3__coches);
        rbEngadir=(RadioButton) findViewById(R.id.engadir);
        rbSobrescribir=(RadioButton) findViewById(R.id.sobrescribir);
        textoEditable=(EditText) findViewById(R.id.etEngadir);
        btnLer=(Button) findViewById(R.id.btnLer);
        btnLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Secundaria.class);
                intent.putExtra("FICHEIRO",nomeFicheiro);
                startActivity(intent);
            }
        });
     }

    public void estadoSD(){
        String estado = Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponhible = true;
            sdAccesoEscritura = true;
        }else{
            Toast.makeText(getBaseContext(),"A SD non está dispoñible en modo escritura.",Toast.LENGTH_SHORT).show();
            System.exit(1);
        }
    }

    public void directorioFicheiro() {
        if (sdDisponhible==true) {;
            dirFicheiroSD = getExternalFilesDir(null);
            rutaCompleta = new File(dirFicheiroSD.getAbsolutePath(), nomeFicheiro);
        }
    }

    public void botonPulsado(View view){
        estadoSD();
        directorioFicheiro();
        if(sdAccesoEscritura==true){
            Calendar calendario=Calendar.getInstance();
            String ruta=dirFicheiroSD.getAbsolutePath().toString();
            if(rbEngadir.isChecked()){
                try {
                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(rutaCompleta,true));
                    osw.write(textoEditable.getText().toString() + " - " + calendario.getTime() + "\n");
                    osw.close();
                    textoEditable.setText("");
                    Log.e("Ruta completa: ", ruta);
                    Log.e("Contido a engadir: : ", textoEditable.getText().toString() + " - "+calendario.getTime());
                } catch (Exception ex) {
                    Toast.makeText(getBaseContext(),"Produciuse un erro escribindo",Toast.LENGTH_SHORT).show();
                }
            }//if

            if(rbSobrescribir.isChecked()){
                try {

                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(rutaCompleta));
                    osw.write(textoEditable.getText() + "\n");
                    osw.close();
                    textoEditable.setText("");
                    Log.e("Ruta completa: ", ruta);
                    Log.e("Contido a engadir: : ", textoEditable.getText().toString() + " - " + calendario.getTime());
                } catch (Exception ex) {
                    Toast.makeText(getBaseContext(),"Produciuse un erro sobrescribindo",Toast.LENGTH_SHORT).show();
                }
            }//if
        }//if
    }//botonPulsado

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u3__coches, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
