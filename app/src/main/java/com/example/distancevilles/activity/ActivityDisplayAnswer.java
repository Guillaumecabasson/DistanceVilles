package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.distancevilles.R;
import com.example.distancevilles.metier.QuestionVilles;

import java.text.DecimalFormat;

public class ActivityDisplayAnswer extends Activity {

    int actual_question;
    int points;
    int vies;
    String user_answer;
    boolean isCorrect;
    private QuestionVilles qVille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_answer);

        TextView tv_phrase = findViewById(R.id.answer);
        Button btn_back = findViewById(R.id.return_questions);

        TextView tv_distance1 = findViewById(R.id.tv_distance1);
        TextView tv_distance2 = findViewById(R.id.tv_distance2);

        String text = "";
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("user_answer")){
                user_answer = intent.getStringExtra("user_answer");
            }
            if (intent.hasExtra("isCorrect")){
                isCorrect = intent.getBooleanExtra("isCorrect", false);
            }
            if (intent.hasExtra("actual_question")){
                actual_question = intent.getIntExtra("actual_question", 0);
            }
            if (intent.hasExtra("points")){
                points = intent.getIntExtra("points", 0);
            }
            if (intent.hasExtra("vies")){
                vies = intent.getIntExtra("vies", 0);
            }
            if (intent.hasExtra("question")){
                qVille = intent.getParcelableExtra("question");
            }

            if (isCorrect) {
                text = "Félicitations, " + user_answer + " était la bonne réponse";
            }
            else {
                text = "Malheureusement, " + user_answer + " n'était pas la bonne réponse";
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(qVille.getDistances()[0]);
        String str2 = df.format(qVille.getDistances()[1]);
        str = str.replaceAll(",", ".");
        str2 = str2.replaceAll(",", ".");
        double dist01 = Double.parseDouble(str);
        double dist02 = Double.parseDouble(str2);

        tv_phrase.setText(text);
        String aff_text1 = qVille.getVille().getNom() + " - " + qVille.getReponses()[0].getNom() + " : " + dist01 + " km";
        String aff_text2 = qVille.getVille().getNom() + " - " + qVille.getReponses()[1].getNom() + " : " + dist02 + " km";
        tv_distance1.setText(aff_text1);
        tv_distance2.setText(aff_text2);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actual_question++;
                Intent intent = new  Intent(getBaseContext(), ActivityJeu.class);
                intent.putExtra("actual_question", actual_question);
                intent.putExtra("points", points);
                intent.putExtra("vies", vies);
                startActivity(intent);

                // Toast.makeText(getBaseContext(), "question actuelle:" + actual_question, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() { // "Neutralise" le bouton back propre au téléphone
       // if (shouldAllowBack()) { super.onBackPressed(); }
       // else { doSomething(); }
    }
}
