package com.example.distancevilles.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.distancevilles.R;

public class ActivityDisplayAnswer extends Activity {

    int actual_question;
    String user_answer;
    boolean isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_answer);

        TextView textView = (TextView) findViewById(R.id.answer);
        Button btn_back = (Button) findViewById(R.id.return_questions);

        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("user_answer")){
                user_answer = intent.getStringExtra("user_answer");
            }
            if (intent.hasExtra("isCorrect")){
                isCorrect = intent.getBooleanExtra("isCorrect", false);
            }
            if (intent.hasExtra("actual_question")){
                actual_question = intent.getIntExtra("actual_question", 0);
            }

            if (isCorrect) {
                String text = "Félicitations, " + user_answer + " était la bonne réponse";
                textView.setText(text);
            }
            else {
                String text = "Malheureusement, " + user_answer + " n'était pas la bonne réponse";
                textView.setText(text);
            }
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actual_question++;
                Intent intent = new  Intent(getBaseContext(), ActivityJeu.class);
                intent.putExtra("actual_question", actual_question);
                startActivity(intent);

                Toast.makeText(getBaseContext(), "question actuelle:" + actual_question, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() { // "Neutralise" le bouton back propre au téléphone
       // if (shouldAllowBack()) { super.onBackPressed(); }
       // else { doSomething(); }
    }
}
