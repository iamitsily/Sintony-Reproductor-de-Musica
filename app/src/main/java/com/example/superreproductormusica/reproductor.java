package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class reproductor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();

    }
    public void Ocultar(View view){
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
}