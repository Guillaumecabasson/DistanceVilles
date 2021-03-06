package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.distancevilles.R;
import com.example.distancevilles.dao.PlayersService;
import com.example.distancevilles.metier.Joueur;

import java.util.Date;

public class Activity_CG_User extends Activity {

    private PlayersService playersDAO;

    EditText username_connection;
    EditText password_connection;
    Button btn_seConnecter;

    EditText username_creation;
    EditText password_creation;
    EditText birthyear_creation;
    Spinner pays_creation;
    Button btn_creation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_user);

        username_connection = (EditText) findViewById(R.id.username_connection);
        password_connection = (EditText) findViewById(R.id.password_connection);
        btn_seConnecter = (Button) findViewById(R.id.btn_connection);

        username_creation = (EditText) findViewById(R.id.username_creation);
        password_creation = (EditText) findViewById(R.id.password_creation);
        birthyear_creation = (EditText) findViewById(R.id.year_creation);
        pays_creation = (Spinner) findViewById(R.id.pays_creation);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        pays_creation.setAdapter(adapter);
        btn_creation = (Button) findViewById(R.id.btn_creation);

        btn_seConnecter.setOnClickListener(v -> {
            // Recherche du joueur correspondant dans la BDD s'il existe
            // ActivityHome.joueur =
            Intent intent = new  Intent(getBaseContext(), Activity_0_Home.class);
            startActivity(intent);
            this.finish();
        });

        btn_creation.setOnClickListener(v -> {
            // V??rification des infos !!


            playersDAO = PlayersService.getInstance(this);
            // Rajout du compte ?? la BDD d'users si le pseudo n'est pas encore utilis??
            Joueur joueur = new Joueur(username_creation.getText().toString(), password_creation.getText().toString(),
                    Integer.parseInt(birthyear_creation.getText().toString()), new Date().getTime(),
                    pays_creation.getSelectedItem().toString(), 0,0);
            playersDAO.insertPlayer(joueur);

            // Si ??a r??ussit
            Activity_0_Home.joueur = joueur;

            Intent intent = new  Intent(getBaseContext(), Activity_0_Home.class);
            startActivity(intent);
            this.finish();
        });

    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au t??l??phone
}
