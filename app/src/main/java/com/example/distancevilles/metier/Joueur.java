package com.example.distancevilles.metier;

public class Joueur {

    private long id;
    private String pseudo;
    private int record;

    public Joueur(long id, String pseudo, int points) {
        setId(id);
        setPseudo(pseudo);
        setRecord(points);
    }

    public Joueur(String pseudo, int points) {
        setPseudo(pseudo);
        setRecord(points);
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

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

}
