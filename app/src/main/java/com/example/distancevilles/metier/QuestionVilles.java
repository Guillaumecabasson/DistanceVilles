package com.example.distancevilles.metier;

public class QuestionVilles {

    private int number;
    private Ville ville;
    private Ville[] reponses;
    private int ind_reponse;

    public QuestionVilles(int number, Ville ville, Ville[] reponses, int ind_reponse) {
        setNumber(number);
        setVille(ville);
        setReponses(reponses);
        setInd_reponse(ind_reponse);
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
