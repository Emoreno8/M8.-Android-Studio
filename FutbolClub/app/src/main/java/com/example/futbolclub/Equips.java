package com.example.futbolclub;

public class Equips {

    private int id;
    private String nom;

    public Equips() {
    }

    public Equips(int id, String nom) {
        this.setId(id);
        this.setNom(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}