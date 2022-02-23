package com.example.distancevilles.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {

    private int idScore;
    private String name;
    private int score;
    private long when;

    public Score(){

    }

    public Score(int idScore, String name, int score, long when) {
        setIdScore(idScore);
        setName(name);
        setScore(score);
        setWhen(when);
    }

    public Score(String name, int score, long when) {
        setName(name);
        setScore(score);
        setWhen(when);
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

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = simpleDateFormat.format(new Date(getWhen()));
        return getIdScore() + ": " + getName() + " -> " + getScore() + " at " + date;
    }
}
