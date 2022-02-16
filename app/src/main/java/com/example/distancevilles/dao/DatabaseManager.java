package com.example.distancevilles.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.distancevilles.metier.Score;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DistanceVille.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table DV_Scores ("
                + " idScore INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL,"
                + " score INTEGER NOT NULL,"
                + " when_ INTEGER NOT NULL"
                + ")";
        db.execSQL(strSql);
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String strSql = "drop table DV_Scores";
        db.execSQL(strSql);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoked");
    }

    public void insertScore(String name, int score){
        name = name.replace("'", "''");
        String strSql = "insert into DV_Scores (name, score, when_) values ('"
                + name + "'," + score + ", " + new Date().getTime() + ")";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "insertScore invoked");
    }

    public List<Score> readTop5() {
        List<Score> scores = new ArrayList<>();

        // 1ère technique : SQL
//        String strSql = "select * from DV_Scores order by score desc limit 10";
//        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);

        Cursor cursor = this.getReadableDatabase().query("DV_Scores", new String[]{"idscore", "name", "score", "when_"},
                null, null, null, null, "score desc", "5");
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Score score = new Score(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), new Date(cursor.getInt(3)));
            scores.add(score);
            cursor.moveToNext();
        }

        cursor.close();

        return scores;
    }
}