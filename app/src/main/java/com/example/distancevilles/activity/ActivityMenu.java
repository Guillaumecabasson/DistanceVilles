package com.example.distancevilles.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.listener.ListenerBoutonQuitter;
import com.example.distancevilles.metier.Joueur;

public class ActivityMenu extends Activity{

    public static Joueur joueur = new Joueur("", 0, 0, 0);

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
        joueur.setName(username);
        joueur.setBest_score(0);

        String helloUser = "Bonjour, " + joueur.getName();
        textViewNom.setText(helloUser);
    }

    @Override
    public void onBackPressed()
    {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMenu.this);

        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Alert !");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
                public void onClick(DialogInterface dialog, int which) {
                    // When the user click yes button then app will close
                    finish();
                }
            });

        // Set the Negative button with No name OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // If user click no then dialog box is canceled.
                dialog.cancel();
            }
        });

        // Create the Alert dialog and show it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}