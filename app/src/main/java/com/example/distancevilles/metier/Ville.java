package com.example.distancevilles.metier;

public class Ville {

    private String nom;
    private double longitude;
    private double latitude;
    private int population;

    public Ville(String nom, double longitude, double latitude, int population) {
        setNom(nom);
        setLongitude(longitude);
        setLatitude(latitude);
        setPopulation(population);
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
