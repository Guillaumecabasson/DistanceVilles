package com.example.distancevilles.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.distancevilles.R;

public class ActivityMenuCityGuesser extends Activity {

    Button buttonJouer;
    Button buttonOptions;
    Button buttonRecords;
    Button buttonQuitter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.buttonJouer = this.findViewById(R.id.buttonJouer);
        this.buttonOptions = this.findViewById(R.id.buttonSettings);
        this.buttonRecords = this.findViewById(R.id.buttonRecords);
        this.buttonQuitter = this.findViewById(R.id.buttonQuitter);

        buttonJouer.setOnClickListener(v -> {
            if(ActivityHome.joueur.getName().equals("Anonymous")) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMenuCityGuesser.this);
                builder.setMessage("En lançant une partie sans vous être connecté(e) auparavant, votre score ne sera pas enregistré ! " +
                        "Souhaitez-vous lancer la partie ?");
                builder.setTitle("Alert !");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getBaseContext(), ActivityJeu.class);
                        startActivity(intent);
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
            else {
                Intent intent = new Intent(getBaseContext(), ActivityJeu.class);
                startActivity(intent);
                this.finish();
            }
        });
        buttonOptions.setOnClickListener(v -> {

        });
        buttonRecords.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityRecords.class);
            startActivity(intent);
            this.finish();
        });
        buttonQuitter.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityHome.class);
            startActivity(intent);
            this.finish();
        });

    }

    @Override
    public void onBackPressed()
    {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMenuCityGuesser.this);
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