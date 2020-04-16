package com.example.futbolclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuClub extends AppCompatActivity {

    ListView llistaJugadors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_club);

        final ConexioSQLiteHelper conn=new ConexioSQLiteHelper(this);

/*
        llistaJugadors=findViewById(R.id.listViewId);

        ArrayAdapter<CharSequence> adaptador= ArrayAdapter.createFromResource(this,R.array.arrayJugadors,
                android.R.layout.simple_list_item_1);

        llistaJugadors.setAdapter(adaptador);
*/



    }
}
