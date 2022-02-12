package com.example.distancevilles.utils;

import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.metier.Ville;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<QuestionVilles> initialiseQuestionsVilles() {
        int i;

        // initialiseVilles();
        // créer lecteur de fichier txt pour stocker ce merdier ailleurs ?
        // https://www.coordonnees-gps.fr/communes/metz-/57463
        Ville Metz = new Ville("Metz", 49.1196964, 6.1763552, 0);
        Ville Nancy = new Ville("Nancy", 48.6937223, 6.1834097, 0);
        Ville Paris = new Ville("Paris", 48.8588897, 2.320041, 0);
        Ville Marseille = new Ville("Marseille", 43.2961743, 5.3699525, 0);
        Ville Lille = new Ville("Lille", 50.6365654, 3.0635282, 0);
        Ville Strasbourg = new Ville("Strasbourg", 48.584614, 7.7507127, 0);
        Ville Nantes = new Ville("Nantes", 47.2186371, -1.5541362, 0);
        Ville Lyon = new Ville("Lyon", 45.7578137, 4.8320114, 0);
        Ville Toulouse = new Ville("Toulouse", 43.6044622, 1.4442469, 0);

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
