package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class listaCanciones extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);
        getSupportActionBar().hide();

        List<Music> items = new ArrayList<Music>();
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#A3E4D7"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#F9E79F"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#EDBB99"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#A3E4D7"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#AEB6BF"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#F1948A"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#C39BD3"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#A3E4D7"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#A3E4D7"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#F9E79F"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#EDBB99"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#A3E4D7"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#AEB6BF"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#F1948A"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#C39BD3"));
        items.add(new Music(1,"Runaway","Aurora","","",R.mipmap.disck,"#A3E4D7"));

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(new MusicList(getApplicationContext(),items));
    }
}