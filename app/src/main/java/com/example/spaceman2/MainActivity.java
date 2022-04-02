package com.example.spaceman2;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    static MediaPlayer player;
    public static int upaljeno;
    private static final String FILE_NAME = "text.txt";
    private static final String NOVAC = "novac.txt";
    public static final String zvuk = "zvuk.txt";
    IOclass olovka = new IOclass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ikona = findViewById(R.id.b_zvuk);
        player = MediaPlayer.create(this, R.raw.zvuk);
        Boolean prvi_put = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("prvi_put", true);
        if(prvi_put)
        {
            olovka.sacuvaj(0,NOVAC);
            olovka.sacuvaj(0,FILE_NAME);
            olovka.sacuvaj(1,zvuk);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("prvi_put", false).commit();
        }
        upaljeno = Integer.parseInt(olovka.ucitaj(zvuk));
        if (upaljeno == 1) {
                player.start();
                player.setLooping(true);
                ikona.setBackgroundResource(R.drawable.zvuk);
        }
        else {
                player.pause();
                player.setLooping(false);
                ikona.setBackgroundResource(R.drawable.zvuk_ugasen);
            }
        sakrij_bar();
        VideoView videoView = findViewById(R.id.fullScreenVideoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pozadina1;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        Button prodavnica = findViewById(R.id.prodavnica);
        prodavnica.setBackgroundResource(R.drawable.shop);

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        player.stop();
        finish();
    }

    private void sakrij_bar() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    public void pali_gasi(View view) {
        Button ikona = findViewById(R.id.b_zvuk);
        if(upaljeno == 1)
        {
            player.pause();
            player.setLooping(false);
            ikona.setBackgroundResource(R.drawable.zvuk_ugasen);
            upaljeno = 0;
            olovka.sacuvaj(upaljeno,zvuk);
        }
        else if (upaljeno == 0) {
            player = MediaPlayer.create(this, R.raw.zvuk);
            player.start();
            player.setLooping(true);
            ikona.setBackgroundResource(R.drawable.zvuk);
            upaljeno = 1;
            olovka.sacuvaj(upaljeno,zvuk);
        }

    }
    public void shop(View view) {
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
        player.stop();
        finish();
    }
}

