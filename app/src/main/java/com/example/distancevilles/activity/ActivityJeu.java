package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.distancevilles.R;
import com.example.distancevilles.dao.JoueurService;
import com.example.distancevilles.metier.Joueur;
import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.utils.Utils;

public class ActivityJeu extends Activity {

    private QuestionVilles questionVilles;
    private int nb_points;
    private int questionActuelle;
    private int nb_vies;
    Button btn_answer1, btn_answer2;
    TextView view_nb_question, textview_question;
    TextView tx_score, tx_vies;

    private JoueurService joueurDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        this.questionVilles = Utils.initialiseQuestionVilles();
        this.questionActuelle = 0;
        this.nb_points = 0;
        this.nb_vies = 3;
        btn_answer1 = this.findViewById(R.id.btn_answer1);
        btn_answer2 = this.findViewById(R.id.btn_answer2);
        view_nb_question = this.findViewById(R.id.view_nb_question);
        textview_question = this.findViewById(R.id.question);
        tx_score = this.findViewById(R.id.aff_score);
        tx_vies = this.findViewById(R.id.aff_vies);

        btn_answer1.setOnClickListener(v -> {
            launchActivityDisplayAnswer(btn_answer1);
        });

        btn_answer2.setOnClickListener(v -> {
            launchActivityDisplayAnswer(btn_answer2);
        });

        //recuperation des data bdd via la DAO
        joueurDAO = JoueurService.getInstance(this);

        //On doit vérifier que l'on ne revient pas d'une ActivityDisplayAnswer
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("actual_question")){
                this.questionActuelle = intent.getIntExtra("actual_question", 0);
            }
            if (intent.hasExtra("points")){
                this.nb_points = intent.getIntExtra("points", 0);
            }
            if (intent.hasExtra("vies")){
                this.nb_vies = intent.getIntExtra("vies", 0);
            }
        }
    }

    private void launchActivityDisplayAnswer(Button btn_answer) {
        boolean isCorrectAnswer = false;
        String user_answer = (String) btn_answer.getText();

        if(questionVilles.getReponses()[questionVilles.getInd_reponse()].getNom().equals(user_answer)){
            isCorrectAnswer = true;
            nb_points++;
        }
        else{
            nb_vies--;
        }

        Joueur joueur = new Joueur("pseudoTest", 20);

        //Création du site dans la bdd
        // joueur.setId(joueurDAO.create(joueur));

        Intent intent = new  Intent(getBaseContext(), ActivityDisplayAnswer.class);
        intent.putExtra("user_answer", user_answer);
        intent.putExtra("isCorrect", isCorrectAnswer);
        intent.putExtra("actual_question", questionActuelle);
        intent.putExtra("points", nb_points);
        intent.putExtra("vies", nb_vies);
        intent.putExtra("question", questionVilles);
        startActivity(intent);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        run();

    }

    private void run() {
        if(nb_vies > 0) { // La partie continue
            String textview_score = "Score : " + nb_points;
            tx_score.setText(textview_score);

            String textview_vies = "Vies : " + nb_vies;
            tx_vies.setText(textview_vies);

            String textview_nb_question = "Question " + (questionActuelle +1);
            view_nb_question.setText(textview_nb_question);

            String textToDisplay = "Quelle est la ville la plus proche de " + questionVilles.getVille().getNom() + " ?" ;
            textview_question.setText(textToDisplay);

            //Faire ça dans une fonction éventuellement, liste de boutons ? Ou juste pour mettre ça dans Utils ?
            btn_answer1.setText(questionVilles.getReponses()[0].getNom());
            btn_answer2.setText(questionVilles.getReponses()[1].getNom());
        }
        else { // Le joueur a perdu
            Intent intent = new  Intent(getBaseContext(), ActivityPerdu.class);
            intent.putExtra("username", ActivityMenu.user);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}