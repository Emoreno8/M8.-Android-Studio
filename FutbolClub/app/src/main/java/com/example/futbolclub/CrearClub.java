package com.example.futbolclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.futbolclub.estructura.Estructura;

public class CrearClub extends AppCompatActivity {

    Button insertar, menu;
    EditText nomEquip, passwordEquip, idEquip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_club);

        //referencias de la interface buttons
        insertar = findViewById(R.id.btnEntrarClub);
        menu = findViewById(R.id.btnMenu);
        //referencias de la interface texts
        idEquip=findViewById(R.id.txtIdEquip);
        nomEquip=findViewById(R.id.txtNomClub);
        passwordEquip=findViewById(R.id.txtPasswordClub);

        //conectar base de dades
        final ConexioSQLiteHelper conn = new ConexioSQLiteHelper(this);

        //al clicar, cridar funcio registrarClub
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //registrarClub();
                SQLiteDatabase db = conn.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Estructura.CAMP_ID_EQUIP,idEquip.getText().toString());
                values.put(Estructura.CAMP_NOM_EQUIP, nomEquip.getText().toString());
                values.put(Estructura.CAMP_PASSWORD_EQUIP, passwordEquip.getText().toString());


                long newInsert = db.insert(Estructura.TAULA_EQUIPS,null,values);

                Toast.makeText(getApplicationContext(),"insert ",Toast.LENGTH_SHORT).show();

            }
        });

        //retornem al menu
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }


/*
    private void registrarClub()
    {
        //final ConexioSQLiteHelper conn = new ConexioSQLiteHelper(this);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Estructura.CAMP_NOM_EQUIP,nomEquip.getText().toString());
        values.put(Estructura.CAMP_PASSWORD_EQUIP,passwordEquip.getText().toString());

        long newInsert = db.insert(Estructura.TAULA_EQUIPS,Estructura.CAMP_NOM_EQUIP,values);

        Toast.makeText(getApplicationContext(),"insert "+newInsert,Toast.LENGTH_SHORT).show();
        db.close();
    }
*/
}
