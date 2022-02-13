package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.distancevilles.R;
import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.utils.Utils;

import java.util.ArrayList;

public class ActivityJeu extends Activity {

    private ArrayList<QuestionVilles> questionVilles;
    private int question_actuelle;
    RadioGroup answers;
    RadioButton answer1, answer2;
    TextView textview_question;
    Button buttonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        this.questionVilles = Utils.initialiseQuestionsVilles();
        this.question_actuelle = 0;
        answers = (RadioGroup) (this.findViewById(R.id.radio_group));
        answer1 = (RadioButton) (this.findViewById(R.id.answer1));
        answer2 = (RadioButton)(this.findViewById(R.id.answer2));
        textview_question = (TextView) (this.findViewById(R.id.question));

        this.buttonValider = (Button) this.findViewById(R.id.btn_validate);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrectAnswer = false;
                String radiovalue = "";

                if (answers.getCheckedRadioButtonId() == -1) {
                    Toast toast = Toast.makeText(getBaseContext(), "Il faut cocher au moins une des réponses", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else { // one of the radio buttons is checked
                    // get selected radioButton from radioGroup
                    int selectedId = answers.getCheckedRadioButtonId();
                    // find the radioButton by returned id
                    RadioButton radioButton = (RadioButton)findViewById(selectedId);
                    // radioButton text
                    radiovalue = (String) radioButton.getText();
                    Toast toast = Toast.makeText(getBaseContext(), "Votre réponse est " + radiovalue, Toast.LENGTH_SHORT);
                    toast.show();

                    // Toast.makeText(activity, "bbb:" + questions.get(numberQ).getReponses()[questions.get(numberQ).getInd_reponse()].getNom(), Toast.LENGTH_SHORT).show();
                    if(questionVilles.get(question_actuelle).getReponses()[questionVilles.get(question_actuelle).getInd_reponse()].getNom().equals(radiovalue)){
                        isCorrectAnswer = true;
                    }
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
                Toast.makeText(this, "question actuelle:" + question_actuelle, Toast.LENGTH_SHORT).show();
            }
        }

        Toast.makeText(this, "question actuelle:" + question_actuelle, Toast.LENGTH_SHORT).show();

        String textToDisplay = "Quelle est la ville la plus proche de " + questionVilles.get(question_actuelle).getVille().getNom() + " ?" ;
        textview_question.setText(textToDisplay);


        for(int i=0; i < answers.getChildCount(); i++){
            ((RadioButton) answers.getChildAt(i)).setText(String.valueOf(questionVilles.get(question_actuelle).getReponses()[i].getNom()));
        }
    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}