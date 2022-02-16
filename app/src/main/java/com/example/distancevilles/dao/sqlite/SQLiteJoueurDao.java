package com.example.distancevilles.dao.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.distancevilles.dao.ServiceDAO;
import com.example.distancevilles.metier.Joueur;

import java.util.LinkedList;
import java.util.List;

public class SQLiteJoueurDao extends SQLiteDao<Joueur> implements ServiceDAO<Joueur> {

    @SuppressLint("StaticFieldLeak")
    private static SQLiteJoueurDao instance;

    private static final String[] allColumns = { DatabaseHelper.COLUMN_JOUEUR_NAME, DatabaseHelper.COLUMN_JOUEUR_BESTSCORE };

    public SQLiteJoueurDao(Context context) {
        super(context);
    }

    public static SQLiteJoueurDao getInstance(Context context) {
        if (instance == null)
            instance = new SQLiteJoueurDao(context);

        return instance;
    }

    @Override
    public long create(Joueur joueur) {
        openWritable();

        ContentValues values = putContentValues(joueur);

        long lastInsertedId = sqLiteDatabase.insert(DatabaseHelper.TABLE_JOUEUR, null, values);

        close();

        return lastInsertedId;
    }

    @Override
    public int update(Joueur joueur) {
        openWritable();

        ContentValues values = putContentValues(joueur);

        int returnedId = sqLiteDatabase.update(DatabaseHelper.TABLE_JOUEUR, values, DatabaseHelper.COLUMN_JOUEUR_ID + " = ?", new String[] { String.valueOf(joueur.getId()) });

        return returnedId;
    }

    @Override
    public int delete(long id) {
        openWritable();

        int returnedId = sqLiteDatabase.delete(DatabaseHelper.TABLE_JOUEUR,
                DatabaseHelper.COLUMN_JOUEUR_ID + " = ?",
                new String[] { String.valueOf(id) });

        close();

        return returnedId;
    }

    @Override
    public Joueur findById(long id) {
        openReadable();

        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_JOUEUR,
                allColumns,
                DatabaseHelper.COLUMN_JOUEUR_ID + " = ?",
                new String[] { String.valueOf(id) },
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
        List<Joueur> joueursList = new LinkedList<>();
        String query = "SELECT  * FROM " + DatabaseHelper.TABLE_JOUEUR;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        Joueur joueur;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            joueur = cursorToObject(cursor);
            joueursList.add(joueur);

            cursor.moveToNext();
        }
        cursor.close();
        close();

        return joueursList;
    }

    @Override
    public Cursor getWithCursor(long id) {
        return sqLiteDatabase.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_JOUEUR + " WHERE id = ?",
                new String[] { String.valueOf(id) });
    }

    @Override
    public Joueur cursorToObject(Cursor cursor) {
        return new Joueur(cursor.getLong(0), cursor.getString(1), cursor.getInt(2));
    }

    private ContentValues putContentValues(Joueur joueur) {
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUMN_JOUEUR_NAME, joueur.getPseudo());
        values.put(DatabaseHelper.COLUMN_JOUEUR_BESTSCORE, joueur.getRecord());

        return values;
    }
}
