package com.example.superreproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final List<Music> items = new ArrayList<Music>();
    public static final List<MusicList> itemsList = new ArrayList<MusicList>();
    public static final MediaPlayer vectormp[] = new MediaPlayer[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        itemsList.clear();
        items.clear();
        //Albunes
        items.add(new Music(0, "All My Demons Greeting Me as a Friend", "Aurora", "", "", R.mipmap.runaway, "#495D80"));
        items.add(new Music(1, "The Search", "NF", "", "", R.mipmap.ohlord, "#292D36"));
        items.add(new Music(2, "MTV Unplugged", "Zoe", "", "", R.mipmap.labiosrotos, "#E5E7E9"));
        items.add(new Music(3, "Limon y Sal", "Julieta Venegas", "", "", R.mipmap.eresparami, "#4b1a21"));
        items.add(new Music(4, "Mon Laferte Vol1", "Mon Laferte", "", "", R.mipmap.tufaltadequerer, "#424949"));
        items.add(new Music(5, "Musas", "Natalia Lafourcade", "", "", R.mipmap.tusisabesquererme, "#ABB2B9"));
        items.add(new Music(6, "Can You Fel The Sun", "Missio", "", "", R.mipmap.losingmymind, "#17202A"));
        items.add(new Music(7, "Born Pink", "Blackpink", "", "", R.mipmap.pinkvenom, "#D98880"));

        //Canciones por album
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

        Intent intent = new Intent(this,login   .class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },1500);
    }
}