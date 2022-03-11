package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.distancevilles.R;

public class ActivityUser extends Activity {

    EditText username_connection;
    EditText password_connection;
    Button btn_seConnecter;

    EditText username_creation;
    EditText password_creation;
    EditText year_creation;
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
        year_creation = (EditText) findViewById(R.id.year_creation);
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
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            intent.putExtra("username", username_connection.getText().toString());
            startActivity(intent);
            this.finish();
        });

    }

    @Override
    public void onBackPressed() { } // "Neutralise" le bouton back propre au téléphone
}
