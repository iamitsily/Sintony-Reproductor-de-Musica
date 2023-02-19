package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class reproductor extends AppCompatActivity {

    ImageButton playPause, next, back, repeat;
    ImageView musicImage;
    TextView name, author;
    int repetir = 2, posicion = 0;
    MediaPlayer vectormp[] = MainActivity.vectormp;
    List<Music> items = MainActivity.items;
    List<MusicList> itemsList = MainActivity.itemsList;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();
        playPause = (ImageButton) findViewById(R.id.play_btn);
        next = (ImageButton) findViewById(R.id.next_btn);
        back = (ImageButton) findViewById(R.id.back_btn);
        repeat = (ImageButton) findViewById(R.id.repeat_btn);
        musicImage = (ImageView) findViewById(R.id.image_music);
        name = (TextView) findViewById(R.id.reproductor_tvname);
        author = (TextView) findViewById(R.id.reproductor_tvauthor);
        linearLayout = (LinearLayout)findViewById(R.id.colorLayout);
        Bundle musicData = getIntent().getExtras();
        asignarData(musicData);


        //vectormp[0] = MediaPlayer.create(this,R.raw.)
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            vectormp[posicion].stop();
            posicion=0;
            reset();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void Ocultar(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void asignarData(Bundle extra) {
        //Traer datos del otro activity
        int id = extra.getInt("id");
        String nameString = extra.getString("name");
        String authorString = extra.getString("author");
        String route = extra.getString("route");
        String route_img = extra.getString("route_img");
        int img = extra.getInt("img");
        String color = extra.getString("color");
        name.setText(nameString);
        author.setText(authorString);
        musicImage.setImageResource(img);
        posicion = id;
        linearLayout.setBackgroundColor(Color.parseColor(color));
        playPause(new View(this));
        ///System.out.println(id + " | " + name + " | " + author + " | " + route + " | " + route_img + " | " + img);
    }

    public void playPause(View view) {
        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            playPause.setImageResource(R.mipmap.play);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            playPause.setImageResource(R.mipmap.pause);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view) {
        if (vectormp[posicion] != null) {
            vectormp[posicion].stop();
            posicion = 0;
            playPause.setImageResource(R.mipmap.play);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
            reset();
            Intent intent = new Intent(this,Menu.class);
            startActivity(intent);
        }
    }

    public void repeat(View view) {
        if (repetir == 1) {
            repeat.setImageResource(R.mipmap.songnext);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            repeat.setImageResource(R.mipmap.repeat);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    public void next(View view) {
        if (posicion < vectormp.length - 1) {
            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                reset();
                posicion++;
                name.setText(MainActivity.items.get(posicion).getName());
                author.setText(MainActivity.items.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.items.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.items.get(posicion).getColor()));
                vectormp[posicion].start();
            } else {
                posicion++;

                name.setText(MainActivity.items.get(posicion).getName());
                author.setText(MainActivity.items.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.items.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.items.get(posicion).getColor()));

            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void back(View view){
        if (posicion>=1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                reset();
                posicion--;

                vectormp[posicion].start();
                name.setText(MainActivity.items.get(posicion).getName());
                author.setText(MainActivity.items.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.items.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.items.get(posicion).getColor()));

            }else{
                posicion--;
                name.setText(MainActivity.items.get(posicion).getName());
                author.setText(MainActivity.items.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.items.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.items.get(posicion).getColor()));

            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void reset(){
        itemsList.clear();
        items.clear();
        items.add(new Music(0, "Runaway", "Aurora", "", "", R.mipmap.runaway, "#495D80"));
        items.add(new Music(1, "Oh Lord", "NF", "", "", R.mipmap.ohlord, "#292D36"));
        items.add(new Music(2, "Die For You", "Valorant", "", "", R.mipmap.dieforyou, "#E74C3C"));
        items.add(new Music(3, "Labios Rotos", "Zoe", "", "", R.mipmap.labiosrotos, "#E5E7E9"));
        items.add(new Music(4, "Eres para mi", "Julieta Venegas", "", "", R.mipmap.eresparami, "#4b1a21"));
        items.add(new Music(5, "Tu falta de querer", "Mon Laferte", "", "", R.mipmap.tufaltadequerer, "#424949"));
        items.add(new Music(6, "Tu si sabes quererme", "Natalia Lafourcade", "", "", R.mipmap.tusisabesquererme, "#ABB2B9"));
        items.add(new Music(7, "Losing My Mind", "Missio", "", "", R.mipmap.losingmymind, "#17202A"));
        items.add(new Music(8, "Antes de ti", "Mon Laferte", "", "", R.mipmap.antesdeti, "#D0D3D4"));
        items.add(new Music(9, "Amor completo", "Mon Laferte", "", "", R.mipmap.amorcompleto, "#626567"));
        items.add(new Music(10, "Hope", "NF", "", "", R.mipmap.hope, "#1F618D"));
        items.add(new Music(11, "Pink Venom", "Blackpink", "", "", R.mipmap.pinkvenom, "#D98880"));

        itemsList.add(new MusicList(0, "Runaway", "Aurora", "", "", R.mipmap.runaway, "#495D80"));
        itemsList.add(new MusicList(1, "Oh Lord", "NF", "", "", R.mipmap.ohlord, "#292D36"));
        itemsList.add(new MusicList(2, "Die For You", "Valorant", "", "", R.mipmap.dieforyou, "#E74C3C"));
        itemsList.add(new MusicList(3, "Labios Rotos", "Zoe", "", "", R.mipmap.labiosrotos, "#E5E7E9"));
        itemsList.add(new MusicList(4, "Eres para mi", "Julieta Venegas", "", "", R.mipmap.eresparami, "#5B2C6F"));
        itemsList.add(new MusicList(5, "Tu falta de querer", "Mon Laferte", "", "", R.mipmap.tufaltadequerer, "#2C3E50"));
        itemsList.add(new MusicList(6, "Tu si sabes quererme", "Natalia Lafourcade", "", "", R.mipmap.tusisabesquererme, "#ABB2B9"));
        itemsList.add(new MusicList(7, "Losing My Mind", "Missio", "", "", R.mipmap.losingmymind, "#17202A"));
        itemsList.add(new MusicList(8, "Antes de ti", "Mon Laferte", "", "", R.mipmap.antesdeti, "#D0D3D4"));
        itemsList.add(new MusicList(9, "Amor completo", "Mon Laferte", "", "", R.mipmap.amorcompleto, "#626567"));
        itemsList.add(new MusicList(10, "Hope", "NF", "", "", R.mipmap.hope, "#1F618D"));
        itemsList.add(new MusicList(11, "Pink Venom", "Blackpink", "", "", R.mipmap.pinkvenom, "#D98880"));

        vectormp[0] = MediaPlayer.create(this,R.raw.runaway);
        vectormp[1] = MediaPlayer.create(this,R.raw.ohlord);
        vectormp[2] = MediaPlayer.create(this,R.raw.dieforyou);
        vectormp[3] = MediaPlayer.create(this,R.raw.labiosrotos);
        vectormp[4] = MediaPlayer.create(this,R.raw.eresparami);
        vectormp[5] = MediaPlayer.create(this,R.raw.tufaltadequerer);
        vectormp[6] = MediaPlayer.create(this,R.raw.tusisabesquererme);
        vectormp[7] = MediaPlayer.create(this,R.raw.losingmymind);
        vectormp[8] = MediaPlayer.create(this,R.raw.antesdeti);
        vectormp[9] = MediaPlayer.create(this,R.raw.amorcompleto);
        vectormp[10] = MediaPlayer.create(this,R.raw.hope);
        vectormp[11] = MediaPlayer.create(this,R.raw.pinkvenom);
    }
}