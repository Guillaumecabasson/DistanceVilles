package com.example.distancevilles.utils;

import com.example.distancevilles.metier.QuestionVilles;
import com.example.distancevilles.metier.Ville;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

    public static QuestionVilles initialiseQuestionVilles() {
        int i;

        // initialiseVilles();
        // OU créer lecteur de fichier txt pour stocker ce merdier ailleurs ?
        // https://www.coordonnees-gps.fr/communes/metz-/57463
        Ville Paris = new Ville("Paris", 48.8588897, 2.320041, 0);
        Ville Marseille = new Ville("Marseille", 43.2961743, 5.3699525, 0);
        Ville Nice = new Ville("Nice", 43.7009358, 7.2683912, 0);
        Ville Strasbourg = new Ville("Strasbourg", 48.584614, 7.7507127, 0);
        Ville Rennes = new Ville("Rennes", 48.1113387, -1.6800198, 0);
        Ville Monaco = new Ville("Monaco", 43.7323492, 7.4276832, 0);
        Ville Lyon = new Ville("Lyon", 45.7578137, 4.8320114, 0);
        Ville Lens = new Ville("Lens", 50.4291723, 2.8319805, 0);
        Ville Nantes = new Ville("Nantes", 47.2186371, -1.5541362, 0);
        Ville Lille = new Ville("Lille", 50.6365654, 3.0635282, 0);
        Ville Montpellier = new Ville("Montpellier", 43.6112422, 3.8767337, 0);
        Ville Brest = new Ville("Brest", 48.3905283, -4.4860088, 0);
        Ville Angers = new Ville("Angers", 47.4739884, -0.5515588, 0);
        Ville Reims = new Ville("Reims", 49.2577886, 4.031926, 0);
        Ville ClermontFerrand = new Ville("Clermont-Ferrand", 45.7774551, 3.0819427, 0);
        Ville Troyes = new Ville("Troyes", 48.2971626, 4.0746257, 0);
        Ville Lorient = new Ville("Lorient", 47.7477336, -3.3660907, 0);
        Ville SaintEtienne = new Ville("Saint-Etienne", 45.4401467, 4.3873058, 0);
        Ville Metz = new Ville("Metz", 49.1196964, 6.1763552, 0);
        Ville Bordeaux = new Ville("Bordeaux", 44.841225, -0.5800364, 0);
        Ville Toulouse = new Ville("Toulouse", 43.6044622, 1.4442469, 0);
        Ville Nancy = new Ville("Nancy", 48.6937223, 6.1834097, 0);
        Ville Vannes = new Ville("Vannes", 47.6586772, -2.7599079, 0);
        Ville LaRochelle = new Ville("La Rochelle", 46.1591126, -1.1520434, 0);
        Ville Tours = new Ville("Tours", 47.3900474, 0.6889268, 0);
        Ville Limoges = new Ville("Limoges", 45.8354243, 1.2644847, 0);
        Ville Grenoble = new Ville("Grenoble", 45.1875602, 5.7357819, 0);

        Ville[] villesFr = {Paris, Marseille, Nice, Strasbourg, Rennes, Monaco, Lyon, Lens, Nantes, Lille, Montpellier, Brest,
                Angers, Reims, ClermontFerrand, Troyes, Lorient, SaintEtienne, Metz, Bordeaux, Toulouse, Nancy, Vannes, LaRochelle,
                Tours, Limoges, Grenoble};

        Random random = new Random();
        int ind_ville_base = random.nextInt(villesFr.length-1); // entre 0 et villes.length - 1
        int ind_v1 = -1, ind_v2 = -1;
        do{
            ind_v1 = random.nextInt(villesFr.length-1);
        }
        while(ind_v1 == ind_ville_base);
        do{
            ind_v2 = random.nextInt(villesFr.length-1);
        }
        while(ind_v2 == ind_ville_base || ind_v2 == ind_v1);

        return new QuestionVilles(2, villesFr[ind_ville_base], new Ville[]{ villesFr[ind_v1], villesFr[ind_v2] });
    }

}
