package com.example.distancevilles.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.distancevilles.activity.ActivityJeu;

public class ListenerValiderReponse implements Button.OnClickListener  {

    Activity activity;

    public ListenerValiderReponse(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
//        Intent switchActivityIntent = new Intent(this.activity, ActivityJeu.class);
//        this.activity.startActivityForResult(switchActivityIntent, 1);
//        this.activity.finish();
        Toast toast = Toast.makeText(activity, "message", 2);
        toast.show();
    }
}