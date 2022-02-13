package com.example.distancevilles.metier;

import android.widget.Toast;

public class QuestionVilles {

    final double EARTH_RADIUS = 6371.009;

    private int nbr_reponses;
    private int number;
    private Ville ville;
    private Ville[] reponses;
    private double[] distances;
    private int ind_reponse;

    public QuestionVilles(int nbr_reponses, int number, Ville ville, Ville[] reponses) {
        setNbr_reponses(nbr_reponses);
        setNumber(number);
        setVille(ville);
        setReponses(reponses);
        setDistances(new double[nbr_reponses]);

        calcule_distances();
    }

    /**
     *
     *  Remplis le tableau des distances. Avec distances[0] la distance entre la ville de base et la première réponse possible,
     *  et distances [1] la distance entre la ville de base et la deuxième réponse possible.
     *
     **/
    private void calcule_distances() {

        this.distances[0] = haversine(ville.getLatitude(), ville.getLongitude(), reponses[0].getLatitude(), reponses[0].getLongitude());
        this.distances[1] = haversine(ville.getLatitude(), ville.getLongitude(), reponses[1].getLatitude(), reponses[1].getLongitude());

        // double rad = 180 / Math.PI;
        // this.distances[0] = (double) (EARTH_RADIUS * Math.PI * Math.sqrt((ville.getLatitude() - reponses[0].getLatitude()) * (ville.getLatitude() - reponses[0].getLatitude()) + Math.cos(ville.getLatitude() / rad) * Math.cos(reponses[0].getLatitude() / rad) * (ville.getLongitude() - reponses[0].getLongitude()) * (ville.getLongitude() - reponses[0].getLongitude())) / 180);
        // this.distances[1] = (double) (EARTH_RADIUS * Math.PI * Math.sqrt((ville.getLatitude() - reponses[1].getLatitude()) * (ville.getLatitude() - reponses[1].getLatitude()) + Math.cos(ville.getLatitude() / rad) * Math.cos(reponses[1].getLatitude() / rad) * (ville.getLongitude() - reponses[1].getLongitude()) * (ville.getLongitude() - reponses[1].getLongitude())) / 180);

        if (distances[0] <= distances[1]) { // ou égal ?
            setInd_reponse(0);
        }
        else {
            setInd_reponse(1);
        }
    }

    public double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return EARTH_RADIUS * c;
    }

    public int getNbr_reponses() {
        return nbr_reponses;
    }

    public void setNbr_reponses(int nbr_reponses) {
        this.nbr_reponses = nbr_reponses;
    }

    public int getNumber() { return number; }

    public void setNumber(int number) {
        this.number = number;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Ville[] getReponses() {
        return reponses;
    }

    public void setReponses(Ville[] reponses) {
        this.reponses = reponses;
    }

    public double[] getDistances() {
        return distances;
    }

    public void setDistances(double[] distances) {
        this.distances = distances;
    }

    public int getInd_reponse() {
        return ind_reponse;
    }

    public void setInd_reponse(int ind_reponse) {
        this.ind_reponse = ind_reponse;
    }
}
