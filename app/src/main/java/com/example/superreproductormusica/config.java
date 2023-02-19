package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        getSupportActionBar().hide();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
           Intent intent = new Intent(this,Menu.class);
           startActivity(intent);
           finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    public void back(View view){
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
        finish();
    }
}