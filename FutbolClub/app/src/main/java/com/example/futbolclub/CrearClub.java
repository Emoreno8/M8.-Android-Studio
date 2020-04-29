package com.example.futbolclub;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CrearClub extends AppCompatActivity {

    Button insertar, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_club);

        //referencias de la interface buttons
        insertar = findViewById(R.id.btnEntrarClub);
        menu = findViewById(R.id.btnMenu);
        //referencias de la interface texts
        final EditText nomEquip = findViewById(R.id.txtNomClub);
        final EditText passwordEquip = findViewById(R.id.txtPasswordClub);
        final EditText pobleEquip = findViewById(R.id.txtPobleClub);


        //al clicar, cridar funcio registrarClub
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String nom = nomEquip.getText().toString();
                String password = passwordEquip.getText().toString();
                String poble= pobleEquip.getText().toString();


                new DescarregaImatge(CrearClub.this).execute(nom, password, poble);
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

    public static class DescarregaImatge extends AsyncTask<String, Void, String>
    {

        private WeakReference<Context> context;

        public DescarregaImatge(Context context)
        {
            this.context = new WeakReference<>(context);
        }



        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... params) {
            String registrar_url = "http://192.168.1.22/projecte_futbol/crear_equips.php";
            String resultat;

            try
            {
                URL url = new URL(registrar_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);


                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

                String nom = params[0];
                String password = params[1];
                String poble = params [2];

                String data = URLEncoder.encode("nom", "UTF-8") + "=" + URLEncoder.encode(nom, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") +"&"+
                        URLEncoder.encode("poble", "UTF-8") + "=" + URLEncoder.encode(poble, "UTF-8") ;

                //System.out.println(data);

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line);
                    //resultat += line;
                }
                resultat = stringBuilder.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                //return  resultat;

            } catch (MalformedURLException e) {
                Log.d("APP", "S'ha utilitzat una URL amb format incorrecte");
                resultat = "S'ha produit un error";

            } catch (IOException e) {

                System.out.println(e);

                Log.d("APP", "Error inesperat!!! Possibles problemes de connexió de xarxa");
                resultat = "S'ha produit un error. Comprova la teva connexió";
            }
            return  resultat;
        }

        @Override
        protected void onPostExecute(String resultat) {
            Toast.makeText(context.get(), resultat, Toast.LENGTH_LONG).show();
        }
    }



}
