package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.distancevilles.R;
import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.utils.Utils;

public class ActivityJeu extends Activity {

    private QuestionVilles questionVilles;
    private int nb_points;
    private int question_actuelle;
    private int nb_vies;
    Button btn_answer1, btn_answer2;
    TextView view_nb_question, textview_question;
    TextView tx_score, tx_vies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        this.questionVilles = Utils.initialiseQuestionVilles();
        this.question_actuelle = 0;
        this.nb_points = 0;
        this.nb_vies = 3;
        btn_answer1 = (Button) (this.findViewById(R.id.btn_answer1));
        btn_answer2 = (Button)(this.findViewById(R.id.btn_answer2));
        view_nb_question = (TextView) (this.findViewById(R.id.view_nb_question));
        textview_question = (TextView) (this.findViewById(R.id.question));
        tx_score = (TextView) (this.findViewById(R.id.aff_score));
        tx_vies = (TextView) (this.findViewById(R.id.aff_vies));

        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrectAnswer = false;
                String radiovalue = (String) btn_answer1.getText();

                if(questionVilles.getReponses()[questionVilles.getInd_reponse()].getNom().equals(radiovalue)){
                    isCorrectAnswer = true;
                    nb_points++;
                }
                else{
                    nb_vies--;
                }

                Intent intent = new  Intent(getBaseContext(), ActivityDisplayAnswer.class);
                intent.putExtra("user_answer", radiovalue);
                intent.putExtra("isCorrect", isCorrectAnswer);
                intent.putExtra("actual_question", question_actuelle);
                intent.putExtra("points", nb_points);
                intent.putExtra("vies", nb_vies);
                startActivity(intent);
            }
        });

        btn_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrectAnswer = false;
                String radiovalue = (String) btn_answer2.getText();

                if(questionVilles.getReponses()[questionVilles.getInd_reponse()].getNom().equals(radiovalue)){
                    isCorrectAnswer = true;
                    nb_points++;
                }
                else{
                    nb_vies--;
                }

                Intent intent = new  Intent(getBaseContext(), ActivityDisplayAnswer.class);
                intent.putExtra("user_answer", radiovalue);
                intent.putExtra("isCorrect", isCorrectAnswer);
                intent.putExtra("actual_question", question_actuelle);
                intent.putExtra("points", nb_points);
                intent.putExtra("vies", nb_vies);
                startActivity(intent);
            }
        });

        //On doit vérifier que l'on ne revient pas d'une ActivityDisplayAnswer
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("actual_question")){
                this.question_actuelle = intent.getIntExtra("actual_question", 0);
            }
            if (intent.hasExtra("points")){
                this.nb_points = intent.getIntExtra("points", 0);
            }
            if (intent.hasExtra("vies")){
                this.nb_vies = intent.getIntExtra("vies", 0);
            }
        }

    }

    @Override
    protected void onStart()
    {
        super.onStart();

        String textview_score = "Score : " + nb_points;
        tx_score.setText(textview_score);

        String textview_vies = "Vies : " + nb_vies;
        tx_vies.setText(textview_vies);

        String textview_nb_question = "Question " + (question_actuelle+1);
        view_nb_question.setText(textview_nb_question);

        String textToDisplay = "Quelle est la ville la plus proche de " + questionVilles.getVille().getNom() + " ?" ;
        textview_question.setText(textToDisplay);

        //Faire ça dans une fonction éventuellement, liste de boutons ? Ou juste pour mettre ça dans Utils ?
        btn_answer1.setText(questionVilles.getReponses()[0].getNom());
        btn_answer2.setText(questionVilles.getReponses()[1].getNom());
    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}