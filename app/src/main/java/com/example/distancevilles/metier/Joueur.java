package com.example.distancevilles.metier;

public class Joueur {

    private long id;
    private String name;
    private String password;
    private int birth_year;
    private long registration_date;
    private String country;
    private int nb_games;
    private int best_score;

    public Joueur(long id, String name, String password, int birth_year, long registration_date, String country, int nb_games, int best_score) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birth_year = birth_year;
        this.registration_date = registration_date;
        this.country = country;
        this.nb_games = nb_games;
        this.best_score = best_score;
    }

    public Joueur(String name, String password, int birth_year, long registration_date, String country, int nb_games, int best_score) {
        this.name = name;
        this.password = password;
        this.birth_year = birth_year;
        this.registration_date = registration_date;
        this.country = country;
        this.nb_games = nb_games;
        this.best_score = best_score;
    }

    public Joueur() { }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public long getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(long registration_date) {
        this.registration_date = registration_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
