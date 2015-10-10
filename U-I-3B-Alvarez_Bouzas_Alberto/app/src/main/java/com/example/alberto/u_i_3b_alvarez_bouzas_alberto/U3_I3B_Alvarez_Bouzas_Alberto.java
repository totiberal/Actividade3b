package com.example.alberto.u_i_3b_alvarez_bouzas_alberto;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class U3_I3B_Alvarez_Bouzas_Alberto extends FragmentActivity {

    private Dialogos dialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3__i3_b__alvarez__bouzas__alberto);
        dialogo=new Dialogos();
    }

    public void btnPulsado(View view){

        FragmentManager fmanager = getSupportFragmentManager();
        Bundle datos=new Bundle();
        if(view.getId()==R.id.v_mensaxe) datos.putInt("MENSAXE",1);
        if(view.getId()==R.id.v_botons) datos.putInt("MENSAXE",2);
        if(view.getId()==R.id.v_lista) datos.putInt("MENSAXE",3);
        if(view.getId()==R.id.v_unica) datos.putInt("MENSAXE",4);
        if(view.getId()==R.id.v_multiple) datos.putInt("MENSAXE",5);
        if(view.getId()==R.id.v_entradaTexto) datos.putInt("MENSAXE",6);
        dialogo.setArguments(datos);
        dialogo.show(fmanager,"");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u3__i3_b__alvarez__bouzas__alberto, menu);
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
