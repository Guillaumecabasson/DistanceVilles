package com.example.distancevilles.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.distancevilles.metier.Score;
import com.example.distancevilles.dao.sqlite.SQLiteCategoryDao;

import java.util.List;

public class CategoryService implements ServiceDAO<Score> {

    private static CategoryService instance;
    public SQLiteCategoryDao sqLiteCategoryDao;

    private CategoryService(Context context){
        sqLiteCategoryDao = SQLiteCategoryDao.getInstance(context);
    }

    public static CategoryService getInstance(Context context) {
        if (instance == null)
            instance = new CategoryService(context);
        return instance;
    }

    @Override
    public long create(Score object) {
        return sqLiteCategoryDao.create(object);
    }

    @Override
    public int update(Score object) {
        return sqLiteCategoryDao.update(object);
    }

    @Override
    public int delete(long id) {
        return sqLiteCategoryDao.delete(id);
    }

    @Override
    public Score findById(long id) {
        return sqLiteCategoryDao.findById(id);
    }

    @Override
    public List<Score> findAll() {
        return sqLiteCategoryDao.findAll();
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteCategoryDao.getWithCursor(id);
    }
}
