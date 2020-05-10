package com.example.futbolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuEquip extends AppCompatActivity {

    Button actJugadors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_equip);

        actJugadors = findViewById(R.id.button5);

        actJugadors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuEquip.this, CrearJugadors.class);
                startActivity(intent);
            }
        });
    }


}