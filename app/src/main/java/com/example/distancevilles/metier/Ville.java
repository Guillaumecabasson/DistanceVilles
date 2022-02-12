package com.example.distancevilles.metier;

public class Ville {

    private String nom;
    private double latitude;
    private double longitude;
    private int population;

    public Ville(String nom, double latitude, double longitude, int population) {
        setNom(nom);
        setLatitude(latitude);
        setLongitude(longitude);
        setPopulation(population);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
