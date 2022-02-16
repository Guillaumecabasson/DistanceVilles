package com.example.distancevilles.metier;

public class Joueur {

    private long id;
    private String pseudo;
    private int score;

    public Joueur(long id, String pseudo, int points) {
        setId(id);
        setPseudo(pseudo);
        setScore(points);
    }

    public Joueur(String pseudo, int points) {
        setPseudo(pseudo);
        setScore(points);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
