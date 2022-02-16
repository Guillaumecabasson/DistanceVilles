package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.distancevilles.R;
import com.example.distancevilles.metier.Joueur;

public class ActivityPerdu extends Activity {

    Button btn_backToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);

        btn_backToMenu = (Button)(this.findViewById(R.id.btn_backToMenu));
        btn_backToMenu.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            startActivity(intent);
        });

        saveScore();
        
//        Intent intent = getIntent();
//        if (intent != null){
//
//        }

    }

    private void saveScore() {
        Joueur joueur = new Joueur("Testeur", 99);
    }

}
