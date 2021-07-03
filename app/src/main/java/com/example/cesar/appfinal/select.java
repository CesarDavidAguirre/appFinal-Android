package com.example.cesar.appfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

    }

    public void reproduEnYoutube(View view){
        Intent intent = new Intent(this,probando.class);
        startActivity(intent);
    }

    public void reproducirEnServidor(View view){
        Intent intent = new Intent(this,VideoYoutube.class);
        startActivity(intent);
    }
}
