package com.example.alberto.u_i_3b_alvarez_bouzas_alberto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by alberto on 10/10/15.
 */
public class Dialogos extends android.app.DialogFragment {
    AlertDialog.Builder venta;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {

        int numero = getArguments().getInt("MENSAXE");
        if (numero == 1) {
            venta = new AlertDialog.Builder(getActivity());
            venta.setTitle("Atención");
            venta.setMessage("Nova amensaxe. Preme o botón 'Back' para volver á pantalla principal");
            return venta.create();
        }
        if(numero==2){
            venta = new AlertDialog.Builder(getActivity());
            venta.setTitle("Enquisa");
            venta.setMessage("Compras sempre en grandes superficies?");
            venta.setCancelable(false);
            venta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Si */
                    Toast.makeText(getActivity(), "Premeches 'Si'", 1).show();
                }
            });
            venta.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Non */
                    Toast.makeText(getActivity(), "Premeches'Non'", 1).show();
                }
            });
            venta.setNeutralButton("Ás veces", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Ás veces */
                    Toast.makeText(getActivity(), "Premeches 'Ás veces'", 1).show();
                }
            });
            return venta.create();
        }
        if(numero==3){
            venta = new AlertDialog.Builder(getActivity());
            venta.setTitle("Escolle unha opción");
            venta.setItems(R.array.elementos_dialog_seleccion, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int opcion) {
                    // O usuario selecciona unha das opcións do listado
                    String[] opcions = getResources().getStringArray(R.array.elementos_dialog_seleccion);
                    Toast.makeText(getActivity(), "Seleccionaches: '" + opcions[opcion] + "'", 1).show();
                }
            });
            return venta.create();
        }
        if(numero==4){
            venta = new AlertDialog.Builder(getActivity());
            venta.setTitle("Selecciona un smartpohone");
            // Non incluír mensaxe dentro de este tipo de diálogo!!!
            final CharSequence[] smartphones = { "iPhone", "Blackberry", "Android" };
            venta.setSingleChoiceItems(smartphones, 0, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int opcion) {
                    // Evento que ocorre cando o usuario selecciona una opción
                    Toast.makeText(getActivity(), "Seleccionaches: " + smartphones[opcion], Toast.LENGTH_SHORT).show();
                }
            });
            venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                    Toast.makeText(getActivity(), "Premeches 'Aceptar'", 1).show();
                }
            });
            venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                    Toast.makeText(getActivity(), "Premeches 'Cancelar'", 1).show();
                }
            });
            return venta.create();
        }
        if(numero==5){
            venta = new AlertDialog.Builder(getActivity());
            venta.setTitle("Selecciona modos de transporte");
            Resources res = getResources();
            final String[] matriz = res.getStringArray(R.array.elementos_dialog_seleccion2);
            // Non incluír mensaxe dentro de este tipo de diálogo!!!
            venta.setMultiChoiceItems(matriz, new boolean[]{false, true, false, true, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                    // Evento que ocorre cando o usuario selecciona unha opción
                    if (isChecked)
                        Toast.makeText(getActivity(), "Seleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity(), "Deseleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                }
            });
            venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                    Toast.makeText(getActivity(), "Premches 'Aceptar'", 1).show();
                }
            });
            venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                    Toast.makeText(getActivity(), "Premeches 'Cancelar'", 1).show();
                }
            });
            return venta.create();

        }
       /* if(numero==6){
            final View rootView = inflater.inflate(R.layout.xml_dialogo, container, false);
            getDialog().setTitle(getTag());
            Button btn = (Button) rootView.findViewById(R.id.buttonPecharDialogo);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    EditText edit = (EditText)rootView.findViewById(R.id.editTexto);
                    valorTexto = edit.getText().toString();
                    ((Dialogos)U3_I3B_Alvarez_Bouzas_Alberto.this.getActivity()).pecharDialogo();
                    dismiss();
                }
            });
        }*/
        return null;
    }
}
