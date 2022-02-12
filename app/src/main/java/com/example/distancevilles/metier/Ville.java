package com.example.distancevilles.metier;

public class Ville {

    private String nom;
    private double longitude;
    private double latitude;
    private int population;

    public Ville(String nom, double longitude, double latitude, int population) {
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
        this.population = population;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
