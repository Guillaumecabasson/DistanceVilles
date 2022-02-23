package com.example.distancevilles.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.distancevilles.metier.Score;
import com.example.distancevilles.dao.sqlite.SQLiteScoresDao;

import java.util.List;

public class ScoresService implements ServiceDAO<Score> {

    private static ScoresService instance;
    public SQLiteScoresDao sqLiteScoresDao;

    private ScoresService(Context context){
        sqLiteScoresDao = SQLiteScoresDao.getInstance(context);
    }

    public static ScoresService getInstance(Context context) {
        if (instance == null)
            instance = new ScoresService(context);
        return instance;
    }

    @Override
    public long create(Score object) {
        return sqLiteScoresDao.create(object);
    }

    @Override
    public int update(Score object) {
        return sqLiteScoresDao.update(object);
    }

    @Override
    public int delete(long id) {
        return sqLiteScoresDao.delete(id);
    }

    @Override
    public Score findById(long id) {
        return sqLiteScoresDao.findById(id);
    }

    @Override
    public List<Score> findAll() {
        return sqLiteScoresDao.findAll();
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteScoresDao.getWithCursor(id);
    }

    public Score cursorToObject(Cursor cursor) { return sqLiteScoresDao.cursorToObject((cursor)); }

    public void insertScore(String name, int score){
        sqLiteScoresDao.insertScore(name, score);
    }

    public List<Score> readTop5() { return sqLiteScoresDao.readTop5();}
}
