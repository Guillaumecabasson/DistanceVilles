package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.dao.ScoresService;

public class Activity_CG_Perdu extends Activity {

    private ScoresService scoresDAO;
    Button btn_backToMenu;
    TextView tv_perdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);

        tv_perdu = (TextView) this.findViewById(R.id.textview_perdu);
        btn_backToMenu = this.findViewById(R.id.btn_backToMenu);
        btn_backToMenu.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), Activity_CG_Menu.class);
            //intent.putExtra("username", username);
            startActivity(intent);
            this.finish();
        });

        int score_final = 0;
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("score")){
                score_final = intent.getIntExtra("score", 0);
            }
        }

        String txt_perdu = "Dommage " + Activity_0_Home.joueur.getName() + ", c'est perdu !";
        tv_perdu.setText(txt_perdu);

        if(!Activity_0_Home.joueur.getName().equals("Anonymous")){
            scoresDAO = ScoresService.getInstance(this);
            scoresDAO.insertScore(Activity_0_Home.joueur.getName(), score_final);
        }
    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}
