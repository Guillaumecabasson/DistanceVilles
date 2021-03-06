package com.example.distancevilles.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.distancevilles.R;

public class Activity_CG_Menu extends Activity {

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
            Intent intent = new Intent(getBaseContext(), Activity_CG_Jeu.class);
            startActivity(intent);
            this.finish();
        });
        buttonOptions.setOnClickListener(v -> {

        });
        buttonRecords.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), Activity_CG_Records.class);
            startActivity(intent);
            this.finish();
        });
        buttonQuitter.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), Activity_0_Home.class);
            startActivity(intent);
            this.finish();
        });

    }

    @Override
    public void onBackPressed()
    {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_CG_Menu.this);
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