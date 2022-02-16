package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.metier.Joueur;

public class ActivityPerdu extends Activity {

    String username;
    Button btn_backToMenu;
    TextView tv_perdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);

        tv_perdu = this.findViewById(R.id.textview_perdu);
        btn_backToMenu = this.findViewById(R.id.btn_backToMenu);
        btn_backToMenu.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            intent.putExtra("username", ActivityMenu.joueur.getPseudo());
            startActivity(intent);
        });

        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("username")) {
                username = intent.getStringExtra("username");
            }
        }

        String txt_perdu = "Dommage " + username + ", c'est perdu !";
        tv_perdu.setText(txt_perdu);

        saveScoreInBDD();

    }

    private void saveScoreInBDD() {
        //Création du site dans la bdd
        ActivityMenu.joueur.setId(ActivityJeu.joueurDAO.create(ActivityMenu.joueur));
    }

}
