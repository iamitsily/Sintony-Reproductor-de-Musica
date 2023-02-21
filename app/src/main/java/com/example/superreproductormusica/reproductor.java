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
        linearLayout = (LinearLayout) findViewById(R.id.colorLayout);
        Bundle musicData = getIntent().getExtras();
        asignarData(musicData);


        //vectormp[0] = MediaPlayer.create(this,R.raw.)
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            vectormp[posicion].stop();
            posicion = 0;
            reset();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void Ocultar(View view) {
        vectormp[posicion].stop();
        posicion = 0;
        reset();
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
            //Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            playPause.setImageResource(R.mipmap.pause);
            //Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view) {
        if (vectormp[posicion] != null) {
            vectormp[posicion].stop();
            posicion = 0;
            playPause.setImageResource(R.mipmap.play);
            //Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
            reset();
            finish();
            /*Intent intent = new Intent(this,Menu.class);
            startActivity(intent);*/
        }
    }

    public void repeat(View view) {
        if (repetir == 1) {
            repeat.setImageResource(R.mipmap.songnext);
            //Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            repeat.setImageResource(R.mipmap.repeat);
            //Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
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
                name.setText(MainActivity.itemsList.get(posicion).getName());
                author.setText(MainActivity.itemsList.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.itemsList.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.itemsList.get(posicion).getColor()));
                vectormp[posicion].start();
            } else {
                posicion++;

                name.setText(MainActivity.itemsList.get(posicion).getName());
                author.setText(MainActivity.itemsList.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.itemsList.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.itemsList.get(posicion).getColor()));

            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        if (posicion >= 1) {
            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                reset();
                posicion--;

                vectormp[posicion].start();
                name.setText(MainActivity.itemsList.get(posicion).getName());
                author.setText(MainActivity.itemsList.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.itemsList.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.itemsList.get(posicion).getColor()));

            } else {
                posicion--;
                name.setText(MainActivity.itemsList.get(posicion).getName());
                author.setText(MainActivity.itemsList.get(posicion).getAuthor());
                musicImage.setImageResource(MainActivity.itemsList.get(posicion).getImg());
                linearLayout.setBackgroundColor(Color.parseColor(MainActivity.itemsList.get(posicion).getColor()));

            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void reset() {
        itemsList.clear();
        items.clear();
        itemsList.add(new MusicList(0,0, "Runaway", "Aurora", R.mipmap.runaway, "#495D80"));
        itemsList.add(new MusicList(1,0, "Conqueror", "Aurora",R.mipmap.runaway, "#495D80"));
        itemsList.add(new MusicList(2,0, "Runing With The wolves", "Aurora",R.mipmap.runaway, "#495D80"));
        vectormp[0] = MediaPlayer.create(this,R.raw.runaway);
        vectormp[1] = MediaPlayer.create(this,R.raw.conqueror);
        vectormp[2] = MediaPlayer.create(this,R.raw.runingwiththewolves);

        itemsList.add(new MusicList(3, 1,"Let You Down", "NF",R.mipmap.ohlord, "#292D36"));
        itemsList.add(new MusicList(4, 1,"Oh Lord", "NF", R.mipmap.ohlord, "#292D36"));
        itemsList.add(new MusicList(5,1, "Hope", "NF",R.mipmap.hope, "#1F618D"));
        vectormp[3] = MediaPlayer.create(this,R.raw.letyoudown);
        vectormp[4] = MediaPlayer.create(this,R.raw.ohlord);
        vectormp[5] = MediaPlayer.create(this,R.raw.hope);

        itemsList.add(new MusicList(6, 2,"Soñe", "Zoe",R.mipmap.labiosrotos, "#E5E7E9"));
        itemsList.add(new MusicList(7, 2,"Poli / Love", "Zoe",R.mipmap.labiosrotos, "#E5E7E9"));
        itemsList.add(new MusicList(8, 2,"Labios Rotos", "Zoe",R.mipmap.labiosrotos, "#E5E7E9"));
        vectormp[6] = MediaPlayer.create(this,R.raw.sone);
        vectormp[7] = MediaPlayer.create(this,R.raw.polilove);
        vectormp[8] = MediaPlayer.create(this,R.raw.labiosrotos);

        itemsList.add(new MusicList(9,3, "Eres para mi", "Julieta Venegas", R.mipmap.eresparami, "#5B2C6F"));
        itemsList.add(new MusicList(10,3, "Me voy", "Julieta Venegas", R.mipmap.eresparami, "#5B2C6F"));
        itemsList.add(new MusicList(11,3, "Dulce Compañia", "Julieta Venegas", R.mipmap.eresparami, "#5B2C6F"));
        vectormp[9] = MediaPlayer.create(this,R.raw.eresparami);
        vectormp[10] = MediaPlayer.create(this,R.raw.mevoy);
        vectormp[11] = MediaPlayer.create(this,R.raw.dulcecompania);

        itemsList.add(new MusicList(12,4, "Tu falta de querer", "Mon Laferte", R.mipmap.tufaltadequerer, "#2C3E50"));
        itemsList.add(new MusicList(13,4, "Antes de ti", "Mon Laferte", R.mipmap.tufaltadequerer, "#2C3E50"));
        itemsList.add(new MusicList(14,4, "Amor completo", "Mon Laferte", R.mipmap.tufaltadequerer, "#2C3E50"));
        vectormp[12] = MediaPlayer.create(this,R.raw.tufaltadequerer);
        vectormp[13] = MediaPlayer.create(this,R.raw.antesdeti);
        vectormp[14] = MediaPlayer.create(this,R.raw.amorcompleto);

        itemsList.add(new MusicList(15,5, "Tu si sabes quererme", "Natalia Lafourcade", R.mipmap.tusisabesquererme, "#ABB2B9"));
        itemsList.add(new MusicList(16,5, "Soledad y el mar", "Natalia Lafourcade", R.mipmap.tusisabesquererme, "#ABB2B9"));
        itemsList.add(new MusicList(17,5, "Mexicana hermosa", "Natalia Lafourcade", R.mipmap.tusisabesquererme, "#ABB2B9"));
        vectormp[15] = MediaPlayer.create(this,R.raw.tusisabesquererme  );
        vectormp[16] = MediaPlayer.create(this,R.raw.soledadymar);
        vectormp[17] = MediaPlayer.create(this,R.raw.mexicana);

        itemsList.add(new MusicList(18,6, "Losing My Mind", "Missio",R.mipmap.losingmymind, "#17202A"));
        itemsList.add(new MusicList(19,6, "Can You Feel The Sun", "Missio",R.mipmap.losingmymind, "#17202A"));
        itemsList.add(new MusicList(20,6, "Cry Baby", "Missio",R.mipmap.losingmymind, "#17202A"));
        vectormp[18] = MediaPlayer.create(this,R.raw.losingmymind);
        vectormp[19] = MediaPlayer.create(this,R.raw.canyoufelthesun);
        vectormp[20] = MediaPlayer.create(this,R.raw.crybaby);

        itemsList.add(new MusicList(21,7, "Pink Venom", "Blackpink", R.mipmap.pinkvenom, "#D98880"));
        itemsList.add(new MusicList(22,7, "Shut Down", "Blackpink", R.mipmap.pinkvenom, "#D98880"));
        itemsList.add(new MusicList(23,7, "How You Like That", "Blackpink", R.mipmap.pinkvenom, "#D98880"));
        vectormp[21] = MediaPlayer.create(this,R.raw.pinkvenom);
        vectormp[22] = MediaPlayer.create(this,R.raw.shutdown);
        vectormp[23] = MediaPlayer.create(this,R.raw.howyoulikethat);
    }
}