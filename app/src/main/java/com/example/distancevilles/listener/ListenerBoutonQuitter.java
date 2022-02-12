package com.example.distancevilles.listener;

import android.view.View;
import android.widget.Button;

public class ListenerBoutonQuitter implements Button.OnClickListener {
    @Override
    public void onClick(View v) {
        System.exit(0);
    }
}
