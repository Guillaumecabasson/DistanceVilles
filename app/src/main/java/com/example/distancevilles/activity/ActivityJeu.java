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

import java.util.ArrayList;

public class ActivityJeu extends Activity {

    private ArrayList<QuestionVilles> questionVilles;
    private int question_actuelle;
    Button btn_answer1, btn_answer2;
    TextView view_nb_question, textview_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        this.questionVilles = Utils.initialiseQuestionsVilles();
        this.question_actuelle = 0;
        btn_answer1 = (Button) (this.findViewById(R.id.btn_answer1));
        btn_answer2 = (Button)(this.findViewById(R.id.btn_answer2));
        view_nb_question = (TextView) (this.findViewById(R.id.view_nb_question));
        textview_question = (TextView) (this.findViewById(R.id.question));

        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrectAnswer = false;
                String radiovalue = (String) btn_answer1.getText();

                if(questionVilles.get(question_actuelle).getReponses()[questionVilles.get(question_actuelle).getInd_reponse()].getNom().equals(radiovalue)){
                    isCorrectAnswer = true;
                }

                Intent intent = new  Intent(getBaseContext(), ActivityDisplayAnswer.class);
                intent.putExtra("user_answer", radiovalue);
                intent.putExtra("isCorrect", isCorrectAnswer);
                intent.putExtra("actual_question", question_actuelle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        //On doit vérifier que l'on ne revient pas d'une ActivityDisplayAnswer
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("actual_question")){
                this.question_actuelle = intent.getIntExtra("actual_question", 0);
            }
        }

        String textview_nbquestion = "Question " + (question_actuelle+1);
        view_nb_question.setText(textview_nbquestion);

        String textToDisplay = "Quelle est la ville la plus proche de " + questionVilles.get(question_actuelle).getVille().getNom() + " ?" ;
        textview_question.setText(textToDisplay);

        //Faire ça dans une fonction éventuellement, liste de boutons ? Ou juste pour mettre ça dans Utils ?
        btn_answer1.setText(questionVilles.get(question_actuelle).getReponses()[0].getNom());
        btn_answer2.setText(questionVilles.get(question_actuelle).getReponses()[1].getNom());
    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}