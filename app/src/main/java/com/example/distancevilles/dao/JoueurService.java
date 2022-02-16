package com.example.distancevilles.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.distancevilles.dao.sqlite.SQLiteJoueurDao;
import com.example.distancevilles.metier.Joueur;

import java.util.List;

public class JoueurService implements ServiceDAO<Joueur> {

    private static JoueurService instance;
    private SQLiteJoueurDao sqLiteCategoryDao;

    private JoueurService(Context context){
        sqLiteCategoryDao = SQLiteJoueurDao.getInstance(context);
    }

    public static JoueurService getInstance(Context context) {
        if (instance == null)
            instance = new JoueurService(context);
        return instance;
    }

    @Override
    public long create(Joueur object) {
        return sqLiteCategoryDao.create(object);
    }

    @Override
    public int update(Joueur object) {
        return sqLiteCategoryDao.update(object);
    }

    @Override
    public int delete(long id) {
        return sqLiteCategoryDao.delete(id);
    }

    @Override
    public Joueur findById(long id) {
        return sqLiteCategoryDao.findById(id);
    }

    @Override
    public List<Joueur> findAll() {
        return sqLiteCategoryDao.findAll();
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteCategoryDao.getWithCursor(id);
    }
}
