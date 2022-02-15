package com.example.distancevilles.metier;

import android.os.Parcel;
import android.os.Parcelable;

public class Ville implements Parcelable {

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

    protected Ville(Parcel in) {
        nom = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        population = in.readInt();
    }

    public static final Creator<Ville> CREATOR = new Creator<Ville>() {
        @Override
        public Ville createFromParcel(Parcel in) {
            return new Ville(in);
        }

        @Override
        public Ville[] newArray(int size) {
            return new Ville[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeInt(population);
    }
}
