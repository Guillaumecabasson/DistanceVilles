package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.dao.CategoryService;
import com.example.distancevilles.dao.sqlite.DatabaseHelper;
import com.example.distancevilles.metier.Score;

import java.util.List;

public class ActivityRecords extends Activity {

    TextView scoresView;
    Button btn_backToMenu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        scoresView = (TextView) this.findViewById(R.id.scoresView);
        btn_backToMenu2 = (Button) this.findViewById(R.id.btn_backToMenu2);
        btn_backToMenu2.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            //intent.putExtra("username", username);
            startActivity(intent);
            this.finish();
        });

        // BUG
        CategoryService scoresDAO = CategoryService.getInstance(this);

        List<Score> scores = scoresDAO.sqLiteCategoryDao.readTop5();
        for(Score score : scores){
            scoresView.append(score.toString() + "\n\n");
        }

        scoresDAO.sqLiteCategoryDao.close();

    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}
