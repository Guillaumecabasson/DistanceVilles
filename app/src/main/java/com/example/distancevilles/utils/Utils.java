package com.example.distancevilles.utils;

import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.metier.Ville;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<QuestionVilles> initialiseQuestionsVilles() {
        int i;

        // initialiseVilles();
        // créer lecteur de fichier txt pour stocker ce merdier ailleurs ?
        Ville Metz = new Ville("Metz", 0, 0, 0);
        Ville Nancy = new Ville("Nancy", 0, 0, 0);
        Ville Paris = new Ville("Paris", 0, 0, 0);
        Ville Marseille = new Ville("Marseille", 0, 0, 0);
        Ville Lille = new Ville("Lille", 0, 0, 0);
        Ville Strasbourg = new Ville("Strasbourg", 0, 0, 0);
        Ville Nantes = new Ville("Nantes", 0, 0, 0);
        Ville Lyon = new Ville("Lyon", 0, 0, 0);

        ArrayList<QuestionVilles> questions = new ArrayList<QuestionVilles>();
        questions.add(new QuestionVilles(0, Metz, new Ville[]{ Nancy, Paris }, 0));
        questions.add(new QuestionVilles(0, Paris, new Ville[]{ Marseille, Lille }, 1));
        questions.add(new QuestionVilles(0, Strasbourg, new Ville[]{ Nantes, Lyon }, 0));

//        for(i=0;i<10;i++){ //tirage de villes au hasard parmi celles dispo et création de questions
//
//        }
        return questions;
    }

}
