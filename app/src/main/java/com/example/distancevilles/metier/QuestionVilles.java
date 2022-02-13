package com.example.distancevilles.metier;

public class QuestionVilles {

    private int number;
    private Ville ville;
    private Ville[] reponses;
    private double[] distances;
    private int ind_reponse;

    public QuestionVilles(int number, Ville ville, Ville[] reponses) {
        setNumber(number);
        setVille(ville);
        setReponses(reponses);
        calcule_distance();
    }

    /**
     *
     *  Remplis le tableau des distances. Avec distances[0] la distance entre la ville de base et la première réponse possible,
     *  et distances [1] la distance entre la ville de base et la deuxième réponse possible.
     *
     **/
    private void calcule_distance() {
        double rad = 180 / Math.PI;
        distances[0] = (double) (6372.795000 * Math.PI * Math.sqrt((ville.getLatitude() - reponses[0].getLatitude()) * (ville.getLatitude() - reponses[0].getLatitude()) + Math.cos(ville.getLatitude() / rad) * Math.cos(reponses[0].getLatitude() / rad) * (ville.getLongitude() - reponses[0].getLongitude()) * (ville.getLongitude() - reponses[0].getLongitude())) / 180);
        distances[1] = (double) (6372.795000 * Math.PI * Math.sqrt((ville.getLatitude() - reponses[1].getLatitude()) * (ville.getLatitude() - reponses[1].getLatitude()) + Math.cos(ville.getLatitude() / rad) * Math.cos(reponses[1].getLatitude() / rad) * (ville.getLongitude() - reponses[1].getLongitude()) * (ville.getLongitude() - reponses[1].getLongitude())) / 180);

        if (distances[0] <= distances[1]) { // ou égal ?
            setInd_reponse(0);
        }
        else {
            setInd_reponse(1);
        }
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

    public int getInd_reponse() {
        return ind_reponse;
    }

    public void setInd_reponse(int ind_reponse) {
        this.ind_reponse = ind_reponse;
    }
}
