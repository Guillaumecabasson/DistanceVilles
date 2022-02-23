package com.example.distancevilles.metier;

public class Joueur {

    private long id;
    private String name;
    private int nb_games;
    private int best_score;
    private long registration_date;

    public Joueur(long id, String name, int nb_games, int best_score, long registration_date) {
        this.id = id;
        this.name = name;
        this.nb_games = nb_games;
        this.best_score = best_score;
        this.registration_date = registration_date;
    }

    public Joueur(String name, int nb_games, int best_score, long registration_date) {
        this.name = name;
        this.nb_games = nb_games;
        this.best_score = best_score;
        this.registration_date = registration_date;
    }

    public Joueur() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNb_games() {
        return nb_games;
    }

    public void setNb_games(int nb_games) {
        this.nb_games = nb_games;
    }

    public int getBest_score() {
        return best_score;
    }

    public void setBest_score(int best_score) {
        this.best_score = best_score;
    }

    public long getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(long registration_date) {
        this.registration_date = registration_date;
    }
}
