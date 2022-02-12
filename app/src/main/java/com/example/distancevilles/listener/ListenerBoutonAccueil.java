package com.example.distancevilles.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.distancevilles.activity.ActivityMenu;

public class ListenerBoutonAccueil implements Button.OnClickListener {
    Activity activity;

    public ListenerBoutonAccueil(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent switchActivityIntent = new Intent(this.activity, ActivityMenu.class);
        this.activity.startActivityForResult(switchActivityIntent, 2);
        this.activity.finish();
    }
}