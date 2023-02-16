package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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




        recyclerView = (RecyclerView) findViewById(R.id.ml_rv);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setAdapter(new Music(getApplicationContext(),items));
        }


}