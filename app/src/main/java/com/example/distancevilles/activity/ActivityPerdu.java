package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.dao.DatabaseManager;
import com.example.distancevilles.metier.Score;

import java.util.List;

public class ActivityPerdu extends Activity {

    private DatabaseManager databaseManager;
    Button btn_backToMenu;
    TextView tv_perdu;
    TextView scoresView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);

        tv_perdu = (TextView) this.findViewById(R.id.textview_perdu);
        scoresView = (TextView) this.findViewById(R.id.scoresView);
        btn_backToMenu = this.findViewById(R.id.btn_backToMenu);
        btn_backToMenu.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            //intent.putExtra("username", username);
            startActivity(intent);
        });

        String txt_perdu = "Dommage " + ActivityMenu.joueur.getPseudo() + ", c'est perdu !";
        tv_perdu.setText(txt_perdu);

        databaseManager = new DatabaseManager(this);

        databaseManager.insertScore(ActivityMenu.joueur.getPseudo(), ActivityMenu.joueur.getScore());

        List<Score> scores = databaseManager.readTop5();
        for(Score score : scores){
            scoresView.append(score.toString() + "\n\n");
        }

        databaseManager.close();

    }

}
