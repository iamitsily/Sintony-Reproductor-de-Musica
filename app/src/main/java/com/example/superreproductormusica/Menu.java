package com.example.superreproductormusica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    TextView textView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
        textView = (TextView) findViewById(R.id.tvBienvenido);
        Bundle bundle = getIntent().getExtras();
        //String nombre = bundle.getString("nombre");
        //textView.setText("Bienvenido "+nombre);
//        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
        recyclerView = (RecyclerView) findViewById(R.id.ml_rv);
        recyclerView.setAdapter(new Music(getApplicationContext(), MainActivity.items));
    }
    public void listaCanciones(View view) {
        Intent intent = new Intent(this, listaCanciones.class);
        startActivity(intent);

    }

    public void Song(View view) {
        Intent intent = new Intent(this, listaCanciones.class);
        intent.putExtra("id", 0);
        intent.putExtra("name", "Runaway");
        intent.putExtra("author", "Aurora");
        intent.putExtra("route", "");
        intent.putExtra("route_img", "");
        intent.putExtra("img", R.mipmap.runaway);
        intent.putExtra("color","#A3E4D7");
        startActivity(intent);
    }
    public void config(View view){
        Intent intent = new Intent(this,config.class);
        startActivity(intent);
    }
}