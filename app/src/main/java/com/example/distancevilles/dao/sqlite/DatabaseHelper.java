package com.example.distancevilles.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance = null;

    public static final String DATABASE_NAME = "DistanceVille.db";
    public static final int DATABASE_VERSION = 1;

    // Noms de colonnes - les noms des colonnes ont les mêmes que ceux de votre base, de même pour les index.
    public static final String TABLE_SCORES = "DV_SCORES";
    public static final String KEY_SCORES_COL_ID = "idScore";
    public static final String KEY_SCORES_COL_NAME = "name";
    public static final String KEY_SCORES_COL_SCORE = "score";
    public static final String KEY_SCORES_COL_DATE = "when_";

    public static final String TABLE_PLAYERS = "DV_PLAYERS";
    public static final String KEY_PLAYERS_COL_ID = "idPlayer";
    public static final String KEY_PLAYERS_COL_NAME = "name";
    public static final String KEY_PLAYERS_COL_NBGAMES = "nbGames";
    public static final String KEY_PLAYERS_COL_BEST_SCORE = "bestScore";
    public static final String KEY_PLAYERS_COL_REGISTR_DATE = "registration";

    private static final String DATABASE_CREATE_SCORES = "CREATE TABLE "
            + TABLE_SCORES
            + "(" + KEY_SCORES_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_SCORES_COL_NAME + " TEXT NOT NULL,"
            + KEY_SCORES_COL_SCORE + " INTEGER NOT NULL,"
            + KEY_SCORES_COL_DATE + " INTEGER NOT NULL"
            + ");";

    private static final String DATABASE_CREATE_PLAYERS = "CREATE TABLE "
            + TABLE_PLAYERS
            + "(" + KEY_PLAYERS_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_PLAYERS_COL_NAME + " TEXT NOT NULL,"
            + KEY_PLAYERS_COL_NBGAMES + " INTEGER NOT NULL,"
            + KEY_PLAYERS_COL_BEST_SCORE + " INTEGER NOT NULL,"
            + KEY_PLAYERS_COL_REGISTR_DATE + " INTEGER NOT NULL"
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
        db.execSQL(DATABASE_CREATE_PLAYERS);
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Mise à jour de la base de données, de la version " + oldVersion + " à la version "
                        + newVersion + ", détruisant les anciennes données");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        super.onDowngrade(sqLiteDatabase, oldVersion, newVersion);
    }
}