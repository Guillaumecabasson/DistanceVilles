package com.example.distancevilles.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance = null;

    public static final String TABLE_JOUEUR = "Joueurs";
    public static final String COLUMN_JOUEUR_ID = "joueur";
    public static final String COLUMN_JOUEUR_NAME = "pseudo";
    public static final String COLUMN_JOUEUR_BESTSCORE = "record";

    private static final String DATABASE_NAME = "DistancesVilles.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_CATEGORY = "CREATE TABLE "
            + TABLE_JOUEUR
            + "(" + COLUMN_JOUEUR_ID + " INTEGER PRIMARY KEY NOT NULL, "
            + COLUMN_JOUEUR_NAME + " TEXT UNIQUE NOT NULL, "
            + COLUMN_JOUEUR_BESTSCORE + " INTEGER );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);

        // context.deleteDatabase(DATABASE_NAME); // SUPPRESSION ANCIENNE BDD

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Mise à jour de la base de données, de la version " + oldVersion + " à la version "
                        + newVersion + ", détruisant les anciennes données");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_JOUEUR);

        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        super.onDowngrade(sqLiteDatabase, oldVersion, newVersion);
    }
}
