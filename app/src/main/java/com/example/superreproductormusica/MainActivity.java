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
    public static final MediaPlayer vectormp[] = new MediaPlayer[12];

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
        Intent intent = new Intent(this,Menu.class);
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