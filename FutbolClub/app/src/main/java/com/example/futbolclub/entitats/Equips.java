package com.example.futbolclub.entitats;

public class Equips {

    private String nomEquip;
    private String passwordEquip;

    public Equips(String nomEquip, String passwordEquip) {
        this.nomEquip = nomEquip;
        this.passwordEquip = passwordEquip;
    }

    public Equips(){    }

    public String getNomEquip() {
        return nomEquip;
    }

    public String getPasswordEquip() {
        return passwordEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public void setPasswordEquip(String passwordEquip) {
        this.passwordEquip = passwordEquip;
    }
}
