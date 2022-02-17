package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.listener.ListenerBoutonQuitter;
import com.example.distancevilles.metier.Joueur;

public class ActivityMenu extends Activity{

    public static Joueur joueur = new Joueur("", 0);

    Button buttonJouer;
    Button buttonCompte;
    Button buttonQuitter;
    TextView textViewNom;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.buttonJouer = this.findViewById(R.id.buttonJouer);
        this.buttonCompte = this.findViewById(R.id.buttonCompte);
        this.buttonQuitter = this.findViewById(R.id.buttonQuitter);
        this.textViewNom = this.findViewById(R.id.textViewNom);

        buttonJouer.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityJeu.class);
            startActivity(intent);
        });
        buttonQuitter.setOnClickListener(new ListenerBoutonQuitter());
        buttonCompte.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityUser.class);
            startActivity(intent);
        });

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
}