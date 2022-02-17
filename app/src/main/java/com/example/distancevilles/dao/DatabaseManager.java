package com.example.distancevilles.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import com.example.distancevilles.metier.Score;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DistanceVille.db";
    public static final int DATABASE_VERSION = 1;
    // Noms de colonnes
    // /!\Si vous utilisez une base de données, les noms des colonnes ont les mêmes que ceux de votre base, de même pour les index.
    // My Column ID and the associated explanation for end-users
    public static final String KEY_COL_ID = "idScore";// Mandatory

    // My Column Name and the associated explanation for end-users
    public static final String KEY_COL_NAME = "name";

    // My Column First Name and the associated explanation for end-users
    public static final String KEY_COL_SCORE = "score";

    // My Column Eyes Color and the associated explanation for end-users
    public static final String KEY_COL_DATE = "when_";

    // Index des colonnes
    // The index of the column ID
    public static final int ID_COLUMN = 1;

    // The index of the column NAME
    public static final int NAME_COLUMN = 2;

    // The index of the column FIRST NAME
    public static final int SCORE_COLUMN = 3;

    // The index of the column EYES COLOR
    public static final int WHEN_COLUMN = 4;


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
        Cursor cursor = this.getReadableDatabase().query("DV_Scores", new String[]{"idscore", "name", "score", "when_"},
                null, null, null, null, null, null);

        cursor.moveToFirst();
        boolean found = false;
        Score score_recup = new Score("null", 0);

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
                content.put(KEY_COL_ID, score_recup.getIdScore());
                content.put(KEY_COL_NAME, score_recup.getName());
                content.put(KEY_COL_SCORE, score);
                content.put(KEY_COL_DATE, new Date().getTime());
                updateRecord(content, score_recup.getIdScore());
            }
        }
        else { //on insère le score de ce nouvel utilisateur
            name = name.replace("'", "''");
            String strSql = "insert into DV_Scores (name, score, when_) values ('"
                    + name + "'," + score + ", " + new Date().getTime() + ")";
            this.getWritableDatabase().execSQL(strSql);
            Log.i("DATABASE", "on insère une nouvelle ligne");
        }

        //Log.i("DATABASE", "insertScore invoked");
    }

    private void updateRecord(ContentValues contentValues, long rowId) {
        Log.i("DATABASE", ""+contentValues.get(KEY_COL_ID));
        Log.i("DATABASE", ""+contentValues.get(KEY_COL_NAME));
        Log.i("DATABASE", ""+contentValues.get(KEY_COL_SCORE));
        Log.i("DATABASE", ""+contentValues.get(KEY_COL_DATE));

        // update the database
        try{
            rowId = this.getWritableDatabase().update("DV_Scores", contentValues, KEY_COL_ID + " = " + rowId, null);
        }
        catch(Exception e){
            Log.i("DATABASE", ""+e);
        }
        // test to see if the insertion was ok
        if (rowId == -1) {
            Log.i("DATABASE", "UPDATE NON FONCTIONNEL");
        } else {
            Log.i("DATABASE", "SCORE ET DATE REMPLACES");
        }
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
            Score score = new Score(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3));
            scores.add(score);
            cursor.moveToNext();
        }

        cursor.close();

        return scores;
    }
}