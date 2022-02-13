package com.example.distancevilles.metier;

public class QuestionVilles {

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
        double rad = 180 / Math.PI;
        this.distances[0] = (double) (6372.795000 * Math.PI * Math.sqrt((ville.getLatitude() - reponses[0].getLatitude()) * (ville.getLatitude() - reponses[0].getLatitude()) + Math.cos(ville.getLatitude() / rad) * Math.cos(reponses[0].getLatitude() / rad) * (ville.getLongitude() - reponses[0].getLongitude()) * (ville.getLongitude() - reponses[0].getLongitude())) / 180);
        this.distances[1] = (double) (6372.795000 * Math.PI * Math.sqrt((ville.getLatitude() - reponses[1].getLatitude()) * (ville.getLatitude() - reponses[1].getLatitude()) + Math.cos(ville.getLatitude() / rad) * Math.cos(reponses[1].getLatitude() / rad) * (ville.getLongitude() - reponses[1].getLongitude()) * (ville.getLongitude() - reponses[1].getLongitude())) / 180);

        if (distances[0] <= distances[1]) { // ou égal ?
            setInd_reponse(0);
        }
        else {
            setInd_reponse(1);
        }
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
