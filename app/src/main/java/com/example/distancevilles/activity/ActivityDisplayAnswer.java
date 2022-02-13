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
            String user_answer = "";
            boolean isCorrect = false;
            if (intent.hasExtra("user_answer")){
                user_answer = intent.getStringExtra("user_answer");
            }
            if (intent.hasExtra("isCorrect")){
                isCorrect = intent.getBooleanExtra("isCorrect", false);
            }
            TextView textView = (TextView) findViewById(R.id.answer);

            if (isCorrect) {
                String text = "Félicitations, " + user_answer + " était la bonne réponse";
                textView.setText(text);
            }
            else {
                String text = "Malheureusement, " + user_answer + " n'était pas la bonne réponse";
                textView.setText(text);
            }
        }
    }

    @Override
    public void onBackPressed() { // "Neutralise" le bouton back propre au téléphone
       // if (shouldAllowBack()) { super.onBackPressed(); }
       // else { doSomething(); }
    }
}
