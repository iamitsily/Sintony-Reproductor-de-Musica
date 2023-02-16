package com.example.superreproductormusica;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Music extends RecyclerView.Adapter<Music.ViewHolderDatos> {
    private int id,img;
    private String name, author, route, route_img,color;
    Context context;
    List<Music> listMusic;
    //Clases del adaptador para el recyclerview

    public Music(int id, String name, String author, String route, String route_img,int img,String color) {
        this.name = name;
        this.author = author;
        this.route = route;
        this.route_img = route_img;
        this.img = img;
        this.color=color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoute_img() {
        return route_img;
    }

    public void setRoute_img(String route_img) {
        this.route_img = route_img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music,null,false);
        //return new ViewHolderDatos(view);
        return new ViewHolderDatos(LayoutInflater.from(context).inflate(R.layout.music,parent,false));
    }
    public Music(Context context, List<Music>listMusic){
        this.context=context;
        this.listMusic = listMusic;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.name.setText(listMusic.get(position).getName());
        holder.author.setText(listMusic.get(position).getAuthor());
        holder.relativeLayout.setBackground(R.mipmap.disck);
        holder.relativeLayout.setBackgroundColor(Color.parseColor(listMusic.get(position).getColor()));
    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        int id;
        TextView name,author;
        LinearLayout relativeLayout;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvm_name);
            author = (TextView) itemView.findViewById(R.id.tvm_author);
            relativeLayout = (LinearLayout) itemView.findViewById(R.id.music_item_linerearL);
        }

    }
}