package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.distancevilles.R;

public class ActivityDisplayAnswer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_answer);

        Intent intent = getIntent();
        if (intent != null){
            String user_reponse = "";
            if (intent.hasExtra("reponse")){
                user_reponse = intent.getStringExtra("reponse");
            }
            TextView textView = (TextView) findViewById(R.id.answer);
            textView.setText("---> " + user_reponse);
        }

        Toast.makeText(getApplicationContext(), "We are moved to second Activity",Toast.LENGTH_LONG).show();
    }

}
