package com.example.distancevilles.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {

    private int idScore;
    private String name;
    private int score;
    private Date when;

    public Score(int idScore, String name, int score, Date when) {
        this.idScore = idScore;
        this.name = name;
        this.score = score;
        this.when = when;
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String toString(){
        //SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:MM");
        //String date = sdf.format(getWhen());
        return getIdScore() + ": " + getName() + " -> " + getScore() + " at " + getWhen().toString();
    }
}
