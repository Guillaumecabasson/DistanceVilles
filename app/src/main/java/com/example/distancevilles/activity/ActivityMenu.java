package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.dao.CategoryService;
import com.example.distancevilles.listener.ListenerBoutonQuitter;
import com.example.distancevilles.metier.Joueur;

public class ActivityMenu extends Activity{

    public static Joueur joueur = new Joueur("", 0);

    Button buttonJouer;
    Button buttonCompte;
    Button buttonRecords;
    Button buttonQuitter;
    TextView textViewNom;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.buttonJouer = this.findViewById(R.id.buttonJouer);
        this.buttonCompte = this.findViewById(R.id.buttonCompte);
        this.buttonRecords = this.findViewById(R.id.buttonRecords);
        this.buttonQuitter = this.findViewById(R.id.buttonQuitter);
        this.textViewNom = this.findViewById(R.id.textViewNom);

        buttonJouer.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityJeu.class);
            startActivity(intent);
            this.finish();
        });
        buttonCompte.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityUser.class);
            startActivity(intent);
            this.finish();
        });
        buttonRecords.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityRecords.class);
            startActivity(intent);
            this.finish();
        });
        buttonQuitter.setOnClickListener(new ListenerBoutonQuitter());

        String username = "Anonymous";
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("username")){ // depuis ActivityUser ou ActivityPerdu
                username = intent.getStringExtra("username");
            }
        }

        //joueur = new Joueur(username, 0); //idealement on le recupere de la bdd juste au-dessus
        joueur.setPseudo(username);
        joueur.setScore(0);

        String helloUser = "Bonjour, " + joueur.getPseudo();
        textViewNom.setText(helloUser);
    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}