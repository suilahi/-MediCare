package com.medicare.Model;

public class Medecin {
    private int id;
    private String nom;
    private String speciality;

    public Medecin(String nom, String speciality) {
        this.nom = nom;
        this.speciality = speciality;
    }
    public Medecin(int id, String nom, String speciality) {
        this.id = id;
        this.nom = nom;
        this.speciality = speciality;
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
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
