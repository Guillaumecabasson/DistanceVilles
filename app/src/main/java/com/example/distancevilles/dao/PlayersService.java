package com.example.distancevilles.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.distancevilles.dao.sqlite.SQLitePlayersDao;
import com.example.distancevilles.metier.Joueur;

import java.util.List;

public class PlayersService implements ServiceDAO<Joueur>{

    private static PlayersService instance;
    private SQLitePlayersDao sqLiteJoueurDao;

    private PlayersService(Context context){
        sqLiteJoueurDao = SQLitePlayersDao.getInstance(context);
    }

    public static PlayersService getInstance(Context context) {
        if (instance == null)
            instance = new PlayersService(context);
        return instance;
    }

    @Override
    public long create(Joueur object) {
        return sqLiteJoueurDao.create(object);
    }

    @Override
    public int update(Joueur object) {
        return sqLiteJoueurDao.update(object);
    }

    @Override
    public int delete(long id) {
        return sqLiteJoueurDao.delete(id);
    }

    @Override
    public Joueur findById(long id) {
        return sqLiteJoueurDao.findById(id);
    }

    @Override
    public List<Joueur> findAll() {
        return sqLiteJoueurDao.findAll();
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteJoueurDao.getWithCursor(id);
    }

    public void insertPlayer(Joueur joueur){
        sqLiteJoueurDao.insertJoueur(joueur);
    }
}
