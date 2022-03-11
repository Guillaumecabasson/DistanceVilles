package com.example.distancevilles.dao.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.distancevilles.dao.ServiceDAO;
import com.example.distancevilles.metier.Joueur;
import com.example.distancevilles.metier.Score;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SQLitePlayersDao extends SQLiteDao<Joueur> implements ServiceDAO<Joueur> {

    @SuppressLint("StaticFieldLeak")
    private static SQLitePlayersDao instance;

    private static final String[] allColumns = { DatabaseHelper.KEY_PLAYERS_COL_ID, DatabaseHelper.KEY_PLAYERS_COL_NAME,
            DatabaseHelper.KEY_PLAYERS_COL_PASSWORD, DatabaseHelper.KEY_PLAYERS_COL_BIRTHYEAR,
            DatabaseHelper.KEY_PLAYERS_COL_REGISTR_DATE, DatabaseHelper.KEY_PLAYERS_COL_COUNTRY,
            DatabaseHelper.KEY_PLAYERS_COL_NBGAMES, DatabaseHelper.KEY_PLAYERS_COL_BEST_SCORE};

    public SQLitePlayersDao(Context context) {
        super(context);
    }

    public static SQLitePlayersDao getInstance(Context context) {
        if (instance == null)
            instance = new SQLitePlayersDao(context);

        return instance;
    }

    @Override
    public long create(Joueur joueur) {
        openWritable();

        ContentValues values = putContentValues(joueur);
        long lastInsertedId = sqLiteDatabase.insert(DatabaseHelper.TABLE_PLAYERS, null, values);
        close();
        return lastInsertedId;
    }

    @Override
    public int update(Joueur joueur) {
        openWritable();

        ContentValues values = putContentValues(joueur);

        return sqLiteDatabase.update(DatabaseHelper.TABLE_PLAYERS, values, DatabaseHelper.KEY_PLAYERS_COL_ID + " = ?", new String[] { String.valueOf(joueur.getId()) });
    }

    @Override
    public int delete(long id) {
        openWritable();

        int returnedId = sqLiteDatabase.delete(DatabaseHelper.TABLE_PLAYERS, DatabaseHelper.KEY_PLAYERS_COL_ID + " = ?",
                new String[] { String.valueOf(id) });

        close();
        return returnedId;
    }

    @Override
    public Joueur findById(long id) {
        openReadable();

        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_PLAYERS, allColumns,
                DatabaseHelper.KEY_PLAYERS_COL_ID + " = ?", new String[] { String.valueOf(id) },
                null, null, null, null);

        cursor.moveToFirst();

        Joueur joueur = cursorToObject(cursor);

        cursor.close();

        close();

        return joueur;
    }

    @Override
    public List<Joueur> findAll() {
        openReadable();

        List<Joueur> joueurs = new LinkedList<>();

        String query = "SELECT  * FROM " + DatabaseHelper.TABLE_PLAYERS;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        Joueur joueur;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            joueur = cursorToObject(cursor);
            joueurs.add(joueur);

            cursor.moveToNext();
        }
        cursor.close();
        close();
        return joueurs;
    }

    /*
    public List<Site> findByCategory(Category category) {
        openReadable();

        List<Site> sites = new LinkedList<>();

        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_SITE,
                allColumns,
                DatabaseHelper.COLUMN_CATEGORY_ID + " = ?",
                new String[] { String.valueOf(category.getId()) },
                null, null, null, null);

        Site site;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            site = cursorToObject(cursor);
            sites.add(site);

            cursor.moveToNext();
        }
        cursor.close();

        close();

        return sites;
    }
     */

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteDatabase.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_PLAYERS + " WHERE id = ?",
                new String[] { String.valueOf(id) });
    }

    @Override
    public Joueur cursorToObject(Cursor cursor) {
        return new Joueur(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3),
                cursor.getString(4), cursor.getInt(5), cursor.getInt(6));
    }

    private ContentValues putContentValues(Joueur joueur) {
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.KEY_PLAYERS_COL_NAME, joueur.getName());
        values.put(DatabaseHelper.KEY_PLAYERS_COL_PASSWORD, joueur.getPassword());
        values.put(DatabaseHelper.KEY_PLAYERS_COL_BIRTHYEAR, joueur.getBirth_year());
        values.put(DatabaseHelper.KEY_PLAYERS_COL_REGISTR_DATE, joueur.getRegistration_date());
        values.put(DatabaseHelper.KEY_PLAYERS_COL_COUNTRY, joueur.getCountry());
        values.put(DatabaseHelper.KEY_PLAYERS_COL_NBGAMES, joueur.getNb_games());
        values.put(DatabaseHelper.KEY_PLAYERS_COL_BEST_SCORE, joueur.getBest_score());

        return values;
    }

    public void insertJoueur(Joueur joueur) {
        openReadable();
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_PLAYERS, new String[]{"idPlayer", "name", "password", "birthyear",
                "registration", "country", "nbGames", "bestScore"}, null, null, null, null, null, null);

        cursor.moveToFirst();
        boolean found = false;
        Joueur joueur_recup = new Joueur();

        while(!cursor.isAfterLast() && !found){
            joueur_recup = new Joueur(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3),
                    cursor.getLong(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7));
            if(joueur_recup.getName().toString().equals(joueur.getName().toString())){
                Log.i("DATABASE", "un utilisateur avec le même nom existe déjà");
                found = true;
            }
            cursor.moveToNext();
        }
        cursor.close();

        if(!found) { create(joueur); }

        close();
    }
}