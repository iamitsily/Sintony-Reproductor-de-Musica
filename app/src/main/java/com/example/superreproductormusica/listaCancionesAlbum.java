package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.sql.SQLOutput;

public class listaCancionesAlbum extends AppCompatActivity {
    RecyclerView recyclerView;
    MusicList adapter;
    ImageView imagenAlbum;
    TextView nombreAlbum,autorAlbum;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones_album);
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        String nombre = bundle.getString("name");
        String author = bundle.getString("author");
        int img = bundle.getInt("img");
        String color = bundle.getString("color");
        linearLayout = (LinearLayout)findViewById(R.id.listaCancionesAlbumLayoutPro);
        linearLayout.setBackgroundColor(Color.parseColor(color));
        imagenAlbum = (ImageView) findViewById(R.id.imagenAlbum);
        nombreAlbum = (TextView) findViewById(R.id.nombreAlbum);
        autorAlbum = (TextView) findViewById(R.id.authorAlbum);

        imagenAlbum.setImageResource(img);
        nombreAlbum.setText(nombre);
        autorAlbum.setText(author);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new MusicList(getApplicationContext(),MainActivity.itemsList,id,1);

        recyclerView.setAdapter(adapter);

    }
}