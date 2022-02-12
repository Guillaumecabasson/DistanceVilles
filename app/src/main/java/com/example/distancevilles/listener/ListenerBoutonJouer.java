package com.example.distancevilles.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.distancevilles.activity.ActivityJeu;

public class ListenerBoutonJouer implements Button.OnClickListener  {

    Activity activity;

    public ListenerBoutonJouer(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent switchActivityIntent = new Intent(this.activity, ActivityJeu.class);
        this.activity.startActivityForResult(switchActivityIntent, 1);
        this.activity.finish();
    }
}
