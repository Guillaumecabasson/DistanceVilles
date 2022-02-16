package com.example.distancevilles.metier;

import java.util.Date;

public class Score {

    private long id;
    private String date;
    private int score;

    public Score(long id, String date, int score) {
        this.id = id;
        this.date = date;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
