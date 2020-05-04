package com.example.futbolclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btnEquips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activar activitat Crear club
        btnCrear = findViewById(R.id.button1);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CrearClub.class);
                startActivity(i);
            }
        });

        //Activar activitat Equips
        btnEquips = findViewById(R.id.button);
        btnEquips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MenuClub.class);
                startActivity(i);
            }
        });

    }


}
