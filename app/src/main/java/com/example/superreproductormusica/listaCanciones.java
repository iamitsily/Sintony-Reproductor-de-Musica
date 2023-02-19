package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class listaCanciones extends AppCompatActivity implements SearchView.OnQueryTextListener{
    RecyclerView recyclerView;
    SearchView txtBuscar;
    MusicList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);
        getSupportActionBar().hide();

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new MusicList(getApplicationContext(),MainActivity.itemsList);
        recyclerView.setAdapter(adapter);
        txtBuscar = (SearchView) findViewById(R.id.txtBuscar);

        txtBuscar.setOnQueryTextListener(this);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filtrado(newText);
        return false;
    }
}