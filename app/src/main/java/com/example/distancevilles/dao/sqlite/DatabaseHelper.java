package com.example.distancevilles.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.distancevilles.metier.Score;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance = null;

    public static final String DATABASE_NAME = "DistanceVille.db";
    public static final int DATABASE_VERSION = 1;

    // Noms de colonnes - les noms des colonnes ont les mêmes que ceux de votre base, de même pour les index.
    public static final String TABLE_SCORES = "DV_SCORES";
    public static final String KEY_COL_ID = "idScore";
    public static final String KEY_COL_NAME = "name";
    public static final String KEY_COL_SCORE = "score";
    public static final String KEY_COL_DATE = "when_";

    // Index des colonnes
    public static final int ID_COLUMN = 1;
    public static final int NAME_COLUMN = 2;
    public static final int SCORE_COLUMN = 3;
    public static final int WHEN_COLUMN = 4;

    private static final String DATABASE_CREATE_SCORES = "CREATE TABLE "
            + TABLE_SCORES
            + "(" + KEY_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_COL_NAME + " TEXT NOT NULL,"
            + KEY_COL_SCORE + " INTEGER NOT NULL,"
            + KEY_COL_DATE + " INTEGER NOT NULL"
            + ");";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCORES);
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Mise à jour de la base de données, de la version " + oldVersion + " à la version "
                        + newVersion + ", détruisant les anciennes données");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);

        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        super.onDowngrade(sqLiteDatabase, oldVersion, newVersion);
    }
}