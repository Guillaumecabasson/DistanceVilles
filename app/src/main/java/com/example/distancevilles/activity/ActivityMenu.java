package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.listener.ListenerBoutonJouer;
import com.example.distancevilles.listener.ListenerBoutonQuitter;

public class ActivityMenu extends Activity{

    static String user;

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

        buttonJouer.setOnClickListener(new ListenerBoutonJouer(this));
        buttonQuitter.setOnClickListener(new ListenerBoutonQuitter());
        buttonCompte.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityUser.class);
            startActivity(intent);
        });

        user = "Anonymous";
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("user")){
                user = intent.getStringExtra("user");
            }
        }
        String helloUser = "Bonjour, " + user;
        textViewNom.setText(helloUser);
    }
}