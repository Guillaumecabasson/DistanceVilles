package com.example.distancevilles.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.listener.ListenerBoutonJouer;
import com.example.distancevilles.listener.ListenerBoutonQuitter;
import com.example.distancevilles.listener.ListenerValiderReponse;
import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.utils.Utils;

import java.util.ArrayList;

public class ActivityJeu extends Activity {

    private ArrayList<QuestionVilles> questionVilles;
    private int niveau;
    RadioGroup answers;
    RadioButton answer1, answer2;
    TextView textview_question;
    Button buttonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        this.questionVilles = Utils.initialiseQuestionsVilles();

        answers = (RadioGroup) (this.findViewById(R.id.radio_group));
        answer1 = (RadioButton) (this.findViewById(R.id.answer1));
        answer2 = (RadioButton)(this.findViewById(R.id.answer2));
        textview_question = (TextView) (this.findViewById(R.id.question));

        this.buttonValider = (Button) this.findViewById(R.id.btn_validate);
        this.buttonValider.setOnClickListener(new ListenerValiderReponse(this, answers));
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        String textToDisplay = "Quelle est la ville la plus proche de " + questionVilles.get(0).getVille().getNom() + " ?" ;
        textview_question.setText(textToDisplay);

        for(int i=0; i < answers.getChildCount(); i++){
            ((RadioButton) answers.getChildAt(i)).setText(String.valueOf(questionVilles.get(0).getReponses()[i].getNom()));
        }
    }
}