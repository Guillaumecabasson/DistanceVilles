package com.example.distancevilles.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.distancevilles.dao.sqlite.SQLitePlayersDao;
import com.example.distancevilles.metier.Joueur;

import java.util.List;

public class PlayersService implements ServiceDAO<Joueur>{

    private static PlayersService instance;
    private SQLitePlayersDao sqLiteSiteDao;

    private PlayersService(Context context){
        sqLiteSiteDao = SQLitePlayersDao.getInstance(context);
    }

    public static PlayersService getInstance(Context context) {
        if (instance == null)
            instance = new PlayersService(context);
        return instance;
    }

    @Override
    public long create(Joueur object) {
        return sqLiteSiteDao.create(object);
    }

    @Override
    public int update(Joueur object) {
        return sqLiteSiteDao.update(object);
    }

    @Override
    public int delete(long id) {
        return sqLiteSiteDao.delete(id);
    }

    @Override
    public Joueur findById(long id) {
        return sqLiteSiteDao.findById(id);
    }

    @Override
    public List<Joueur> findAll() {
        return sqLiteSiteDao.findAll();
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteSiteDao.getWithCursor(id);
    }

}
