package com.example.superreproductormusica;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Music extends RecyclerView.Adapter<Music.ViewHolderDatos> implements Serializable {
    private int id, img;
    private String name, author, route, route_img, color;
    Context context;
    List<Music> listMusic;

    public Music(int id, String name, String author, String route, String route_img, int img, String color) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.route = route;
        this.route_img = route_img;
        this.img = img;
        this.color = color;

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

        return new ViewHolderDatos(LayoutInflater.from(context).inflate(R.layout.music, parent, false));
    }

    public Music(Context context, List<Music> listMusic) {
        this.context = context;
        this.listMusic = listMusic;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.name.setText(listMusic.get(position).getName());
        holder.author=listMusic.get(position).getAuthor();
        holder.Image.setBackgroundResource(listMusic.get(position).getImg());
        holder.relativeLayout.setBackgroundColor(Color.parseColor(listMusic.get(position).getColor()));
        holder.id = listMusic.get(position).getId();
        holder.img = listMusic.get(position).getImg();
       // holder.route = listMusic.get(position).getRoute();
        //holder.route_img = listMusic.get(position).getRoute_img();
        holder.color=listMusic.get(position).getColor();
        //set events
        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {
        int id, idAlbum,img;
        String /*route, route_img,*/color,author;
        Context context;
        TextView name;
        LinearLayout relativeLayout, Image;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            name = (TextView) itemView.findViewById(R.id.tvm_name);
            //author = (TextView) itemView.findViewById(R.id.tvm_author);
            relativeLayout = (LinearLayout) itemView.findViewById(R.id.music_item_linerearL);
            Image = (LinearLayout) itemView.findViewById(R.id.music_item_lyimage);
        }

        public void setOnClickListener() {
            relativeLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //int id, String name, String author, String route, String route_img,int img,String color
            Intent intent = new Intent(context, listaCancionesAlbum.class);
            intent.putExtra("id", id);
            intent.putExtra("name", name.getText());
            intent.putExtra("author", author);
            //intent.putExtra("route", route);
            //intent.putExtra("route_img", route_img);
            intent.putExtra("img", img);
            intent.putExtra("color",color);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}