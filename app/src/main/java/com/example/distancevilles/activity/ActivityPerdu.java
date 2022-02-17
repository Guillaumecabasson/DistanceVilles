package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;

public class ActivityPerdu extends Activity {

    Button btn_backToMenu;
    TextView tv_perdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);

        tv_perdu = (TextView) this.findViewById(R.id.textview_perdu);
        btn_backToMenu = this.findViewById(R.id.btn_backToMenu);
        btn_backToMenu.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            //intent.putExtra("username", username);
            startActivity(intent);
            this.finish();
        });

        String txt_perdu = "Dommage " + ActivityMenu.joueur.getPseudo() + ", c'est perdu !";
        tv_perdu.setText(txt_perdu);

    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}
