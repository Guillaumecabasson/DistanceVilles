package com.example.distancevilles.metier;

public class Pays {
    private String nom;
    private int population;
    private int superficie;

    public Pays(String nom, int population, int superficie) {
        this.nom = nom;
        this.population = population;
        this.superficie = superficie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
}
