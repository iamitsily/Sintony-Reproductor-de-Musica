package com.example.superreproductormusica;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MusicList extends RecyclerView.Adapter<MusicList.ViewHolderDatos>{
    private int id,idAlbum,img,FromPantalla,idAlbumOut;
    private String name, author,color;
    Context context;

    List<MusicList> listMusic;
    List<MusicList>listOriginal;
    List<MusicList>listAlbum = new ArrayList<>();
    public MusicList(int id, int idAlbum,String name, String author,int img,String color) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.img = img;
        this.color=color;
        this.idAlbum = idAlbum;

    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
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
        return new ViewHolderDatos(LayoutInflater.from(context).inflate(R.layout.musiclist,parent,false));
    }
    public MusicList(Context context, List<MusicList>listMusic, int idAlbumOutPro, int FromPantalla){
        System.out.println("ConstructorMusicList "+idAlbumOutPro);
        idAlbumOut = idAlbumOutPro;
        System.out.println("idAlbumOut: "+this.idAlbumOut);
        this.context=context;
        this.listMusic = listMusic;
        this.FromPantalla = FromPantalla;
        listOriginal = new ArrayList<>();
        listOriginal.addAll(listMusic);

        for (int i=0;i<listMusic.size();i++){
            if (listMusic.get(i).getIdAlbum()==idAlbumOut){
                listAlbum.add(listMusic.get(i));
            }

        }

    }
    public void filtrado(String musica){
        int longitud = musica.length();
        if (longitud==0){
            listMusic.clear();
            listMusic.addAll(listOriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<MusicList> filtrado = listMusic.stream().filter(i->i.getName().toLowerCase().contains(musica.toLowerCase())).collect(Collectors.toList());
                listMusic.clear();
                listMusic.addAll(filtrado);
            }else{
                for (MusicList c : listMusic) {
                    if (c.getName().toLowerCase().contains(musica.toLowerCase())){
                        listMusic.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        if (FromPantalla==1){
            System.out.println(idAlbumOut +" | "+listAlbum.get(position).getIdAlbum());
            holder.name.setText(listAlbum.get(position).getName());
            holder.author.setText(listAlbum.get(position).getAuthor());
            holder.imageView.setImageResource(listAlbum.get(position).getImg());
            holder.id = listAlbum.get(position).getId();
            holder.img = listAlbum.get(position).getImg();
            holder.color=listAlbum.get(position).getColor();
            holder.setOnClickListener();

        }else{
            holder.name.setText(listMusic.get(position).getName());
            holder.author.setText(listMusic.get(position).getAuthor());
            holder.imageView.setImageResource(listMusic.get(position).getImg());
            holder.id = listMusic.get(position).getId();
            holder.img = listMusic.get(position).getImg();
            holder.color=listMusic.get(position).getColor();
            holder.setOnClickListener();
        }


    }

    @Override
    public int getItemCount() {
        if (FromPantalla==1){
            return listAlbum.size();
        }else{
            return listMusic.size();
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener{
        int id,img;
        String route, route_img,color;
        Context context;
        TextView name,author;
        ImageView imageView;
        LinearLayout relativeLayout;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name = (TextView) itemView.findViewById(R.id.musiclist_textview);
            author = (TextView) itemView.findViewById(R.id.musiclist_textview2);
            imageView = (ImageView) itemView.findViewById(R.id.musiclist_imgview);
            relativeLayout = (LinearLayout) itemView.findViewById(R.id.musiclist_relativelayout);
        }
        public void setOnClickListener(){
            relativeLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //int id, String name, String author, String route, String route_img,int img,String color
            Intent intent = new Intent(context,reproductor.class);
            intent.putExtra("id",id);
            intent.putExtra("name",name.getText());
            intent.putExtra("author",author.getText());
            intent.putExtra("img",img);
            intent.putExtra("color",color);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
