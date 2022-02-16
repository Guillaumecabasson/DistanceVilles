package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.distancevilles.R;

public class ActivityUser extends Activity {

    EditText username_edit;
    Button btn_backMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_user);

        username_edit = findViewById(R.id.username_edit);
        btn_backMenu = findViewById(R.id.btn_backMenu);

        btn_backMenu.setOnClickListener(v -> {
            Intent intent = new  Intent(getBaseContext(), ActivityMenu.class);
            intent.putExtra("username", username_edit.getText().toString());
            startActivity(intent);
        });

    }

}
