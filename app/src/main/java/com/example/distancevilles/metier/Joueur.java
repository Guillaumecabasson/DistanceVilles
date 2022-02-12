package com.example.distancevilles.metier;

import java.util.Date;

public class Joueur {

    private String pseudo;
    private Date birthday;
    private int points;

    public Joueur(String pseudo, Date birthday, int points) {
        this.pseudo = pseudo;
        this.birthday = birthday;
        this.points = points;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
