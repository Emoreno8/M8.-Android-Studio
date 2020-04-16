package com.example.futbolclub.estructura;

import android.provider.BaseColumns;

public class Estructura {

    public Estructura(){}

    //camps taulas
    public static final String TAULA_EQUIPS="equips";
    public static final String CAMP_ID_EQUIP="idEquip";
    public static final String CAMP_NOM_EQUIP="nomEquip";
    public static final String CAMP_PASSWORD_EQUIP="passwordEquip";


    public static final String CREAR_TAULA_EQUIPS=
            "CREATE TABLE " + Estructura.TAULA_EQUIPS+" ("+
                    Estructura.CAMP_ID_EQUIP+"INTEGER PRIMARY KEY," +
                    Estructura.CAMP_NOM_EQUIP+" TEXT,"+
                    Estructura.CAMP_PASSWORD_EQUIP+ "TEXT)";


    public static final String BORRAR_TAULA=
            "DROP TABLE IF EXISTS " + Estructura.TAULA_EQUIPS;




}
