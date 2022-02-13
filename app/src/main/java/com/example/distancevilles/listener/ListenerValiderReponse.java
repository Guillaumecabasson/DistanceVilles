package com.example.distancevilles.listener;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.distancevilles.R;
import com.example.distancevilles.activity.ActivityJeu;

public class ListenerValiderReponse implements Button.OnClickListener  {

    Activity activity;
    RadioGroup radio_answers;

    public ListenerValiderReponse(Activity activity, RadioGroup radiogroup){
        this.activity = activity;
        this.radio_answers = radiogroup;
    }

    @Override
    public void onClick(View v) {
//        Intent switchActivityIntent = new Intent(this.activity, ActivityJeu.class);
//        this.activity.startActivityForResult(switchActivityIntent, 1);
//        this.activity.finish();

        if (this.radio_answers.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(activity, "Il faut cocher au moins une des réponses", Toast.LENGTH_SHORT);
            toast.show();
        }
        else { // one of the radio buttons is checked
            // get selected radioButton from radioGroup
            int selectedId = this.radio_answers.getCheckedRadioButtonId();

            // find the radioButton by returned id
            RadioButton radioButton = (RadioButton)activity.findViewById(selectedId);

            // radioButton text
            CharSequence radiovalue = radioButton.getText();
            Toast toast = Toast.makeText(activity, "Votre réponse est " + radiovalue, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}