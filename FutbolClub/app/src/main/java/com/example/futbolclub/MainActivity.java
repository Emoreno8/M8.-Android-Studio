package com.example.futbolclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btnEntrar;

    /*
    Spinner comboEquips;
    ArrayList<String> llistaEquips;
    ArrayList<Equips> equipsLlista;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        comboEquips=findViewById(R.id.spinner);

        consultaLlistaEquips();

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter (this,android.R.layout.simple_spinner_item,llistaEquips);
        comboEquips.setAdapter(adaptador);
*/

        //Activar activitat Crear club
        btnCrear = findViewById(R.id.btnCrearClub);
        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CrearClub.class);
                startActivity(i);
            }
        });

        //Activar activitat Entrar menu club
        btnEntrar = findViewById(R.id.btnEntrarClub);
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MenuClub.class);
                startActivity(i);
            }
        });



    }


    /*
    private void consultaLlistaEquips()
    {
        SQLiteDatabase db = conn.getReadableDatabase();

        Equips equips=null;
        equipsLlista=new ArrayList<Equips>();

        //selecionem tots els equips
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Estructura.TAULA_EQUIPS,null);

        while (cursor.moveToNext()){
            equips=new Equips();
            equips.setNomEquip(cursor.getString(0));
            equips.setPasswordEquip(cursor.getString(1));

            Log.i("nomEquip",equips.getNomEquip().toString());
            Log.i("passwordEquip",equips.getPasswordEquip().toString());

            equipsLlista.add(equips);
        }
        obtindreLlista();

    }

    private void obtindreLlista()
    {
        llistaEquips=new ArrayList<String>();
        llistaEquips.add("Seleccione");

        for(int i=0; i<equipsLlista.size(); i++)
        {
            llistaEquips.add(equipsLlista.get(i).getNomEquip()+" - "+equipsLlista.get(i).getPasswordEquip());
        }

    }


     */
}
