package com.example.distancevilles.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.example.distancevilles.R;
import com.example.distancevilles.listener.ListenerBoutonJouer;
import com.example.distancevilles.listener.ListenerBoutonQuitter;

public class ActivityMenu extends Activity{

    Button buttonJouer;
    Button buttonQuitter;
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.buttonJouer = (Button) this.findViewById(R.id.buttonJouer);
        this.buttonQuitter = (Button) this.findViewById(R.id.buttonQuitter);

        buttonJouer.setOnClickListener(new ListenerBoutonJouer(this));
        buttonQuitter.setOnClickListener(new ListenerBoutonQuitter());
    }
}