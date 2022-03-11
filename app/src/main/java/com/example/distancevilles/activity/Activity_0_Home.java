package com.example.distancevilles.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.metier.Joueur;

public class Activity_0_Home extends Activity{

    public static Joueur joueur = new Joueur("Anonymous", "", 1900, 0, "", 0 , 0);

    Button buttonJouer;
    Button buttonCompte;
    Button buttonQuitter;
    TextView textViewNom;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.buttonJouer = this.findViewById(R.id.buttonJouerCityGuesser);
        this.buttonCompte = this.findViewById(R.id.buttonCompte);
        this.buttonQuitter = this.findViewById(R.id.buttonQuitter);
        this.textViewNom = this.findViewById(R.id.textViewNom);

        buttonJouer.setOnClickListener(v -> {
            if(Activity_0_Home.joueur.getName().equals("Anonymous")) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_0_Home.this);
                builder.setMessage("En lançant une partie sans vous être connecté(e) auparavant, votre score " +
                        "ne pourra pas être enregistré ! Souhaitez-vous quand même continuer ?");
                builder.setTitle("Attention !");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getBaseContext(), Activity_CG_Menu.class);
                        startActivity(intent);
                        finish();
                    }
                });

                // Set the Negative button with No name OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("J'ai oublié de m'identifier", new DialogInterface.OnClickListener() {
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
            else {
                Intent intent = new Intent(getBaseContext(), Activity_CG_Menu.class);
                startActivity(intent);
                this.finish();
            }
        });
        buttonCompte.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), Activity_CG_User.class);
            startActivity(intent);
        });
        buttonQuitter.setOnClickListener(v -> {
            System.exit(0);
        });

        String username = "Anonymous";
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("username")){ // depuis ActivityUser ou ActivityPerdu
                username = intent.getStringExtra("username");
            }
        }

        String helloUser = "Bonjour, " + Activity_0_Home.joueur.getName();
        textViewNom.setText(helloUser);
    }

    @Override
    public void onBackPressed()
    {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_0_Home.this);

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