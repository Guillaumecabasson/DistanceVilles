package com.example.distancevilles.dao.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.distancevilles.metier.Score;
import com.example.distancevilles.dao.ServiceDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SQLiteCategoryDao extends SQLiteDao<Score> implements ServiceDAO<Score> {

    @SuppressLint("StaticFieldLeak")
    private static SQLiteCategoryDao instance;

    private static final String[] allColumns = { DatabaseHelper.KEY_COL_ID, DatabaseHelper.KEY_COL_NAME
            , DatabaseHelper.KEY_COL_SCORE, DatabaseHelper.KEY_COL_DATE};

    public SQLiteCategoryDao(Context context) {
        super(context);
    }

    public static SQLiteCategoryDao getInstance(Context context) {
        if (instance == null)
            instance = new SQLiteCategoryDao(context);

        return instance;
    }

    @Override
    public long create(Score score) {
        openWritable();

        ContentValues values = putContentValues(score);
        long lastInsertedId = sqLiteDatabase.insert(DatabaseHelper.TABLE_SCORES, null, values);

        close();
        return lastInsertedId;
    }

    @Override
    public int update(Score score) {
        openWritable();

        ContentValues values = putContentValues(score);
        int returnedId = sqLiteDatabase.update(DatabaseHelper.TABLE_SCORES, values, DatabaseHelper.KEY_COL_ID + " = ?",
                new String[] { String.valueOf(score.getIdScore()) });

        return returnedId;
    }

    @Override
    public int delete(long id) {
        openWritable();

        int returnedId = sqLiteDatabase.delete(DatabaseHelper.TABLE_SCORES, DatabaseHelper.KEY_COL_ID + " = ?",
                new String[] { String.valueOf(id) });

        close();
        return returnedId;
    }

    @Override
    public Score findById(long id) {
        openReadable();

        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_SCORES, allColumns, DatabaseHelper.KEY_COL_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        cursor.moveToFirst();
        Score score = cursorToObject(cursor);
        cursor.close();
        close();
        return score;
    }

    @Override
    public List<Score> findAll() {
        openReadable();

        List<Score> scores = new LinkedList<>();

        String query = "SELECT  * FROM " + DatabaseHelper.TABLE_SCORES;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        Score score;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            score = cursorToObject(cursor);
            scores.add(score);

            cursor.moveToNext();
        }
        cursor.close();
        close();

        return scores;
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteDatabase.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_SCORES + " WHERE id = ?",
                new String[] { String.valueOf(id) });
    }

    @Override
    public Score cursorToObject(Cursor cursor) {
        return new Score(cursor.getString(0), cursor.getInt(1), cursor.getLong(2));
    }

    private ContentValues putContentValues(Score score) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_COL_NAME, score.getScore());
        values.put(DatabaseHelper.KEY_COL_SCORE, score.getName());
        values.put(DatabaseHelper.KEY_COL_DATE, score.getWhen());
        return values;
    }

    public void insertScore(String name, int score){
        openReadable();
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_SCORES, new String[]{"idscore", "name", "score", "when_"},
                null, null, null, null, null, null);

        cursor.moveToFirst();
        boolean found = false;
        Score score_recup = new Score();

        while(!cursor.isAfterLast() && !found){
            score_recup = new Score(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3));
            if(score_recup.getName().equals(name)){
                Log.i("DATABASE", "une ligne de même utilisateur a été trouvée");
                found = true;
            }
            cursor.moveToNext();
        }
        cursor.close();

        if(found){
            Log.i("DATABASE", "JOUEUR TROUVE : ");
            if(score > score_recup.getScore()) {
                ContentValues content = new ContentValues();
                content.put(DatabaseHelper.KEY_COL_ID, score_recup.getIdScore());
                content.put(DatabaseHelper.KEY_COL_NAME, score_recup.getName());
                content.put(DatabaseHelper.KEY_COL_SCORE, score);
                content.put(DatabaseHelper.KEY_COL_DATE, new Date().getTime());
                updateRecord(content, score_recup.getIdScore());
            }
        }
        else { //on insère le score de ce nouvel utilisateur
            name = name.replace("'", "''");
            String strSql = "insert into " + DatabaseHelper.TABLE_SCORES + " (name, score, when_) values ('"
                    + name + "'," + score + ", " + new Date().getTime() + ")";
            sqLiteDatabase.execSQL(strSql);
            Log.i("DATABASE", "on insère une nouvelle ligne");
        }
        close();
    }

    private void updateRecord(ContentValues contentValues, long rowId) {
        Log.i("DATABASE", ""+contentValues.get(DatabaseHelper.KEY_COL_ID));
        Log.i("DATABASE", ""+contentValues.get(DatabaseHelper.KEY_COL_NAME));
        Log.i("DATABASE", ""+contentValues.get(DatabaseHelper.KEY_COL_SCORE));
        Log.i("DATABASE", ""+contentValues.get(DatabaseHelper.KEY_COL_DATE));

        // update the database
        try{
            rowId = sqLiteDatabase.update(DatabaseHelper.TABLE_SCORES, contentValues, DatabaseHelper.KEY_COL_ID + " = " + rowId, null);
            // test to see if the insertion was ok
            if (rowId == -1) {
                Log.i("DATABASE", "UPDATE NON FONCTIONNEL");
            } else {
                Log.i("DATABASE", "SCORE ET DATE REMPLACES");
            }
        }
        catch(Exception e){
            Log.i("DATABASE EXCEPTION", ""+e);
        }
    }

    public List<Score> readTop5() {
        List<Score> scores = new ArrayList<>();

        // 1ère technique : SQL
//        String strSql = "select * from DV_Scores order by score desc limit 10";
//        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);

        openReadable();
        Log.i("DATABASE INFO", ""+DatabaseHelper.TABLE_SCORES);
        Cursor cursor = instance.sqLiteDatabase.query(DatabaseHelper.TABLE_SCORES, new String[]{"idscore", "name", "score", "when_"},
                null, null, null, null, "score desc", "5");
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Score score = new Score(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3));
            scores.add(score);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return scores;
    }
}
