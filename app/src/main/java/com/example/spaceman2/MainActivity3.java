
package com.example.spaceman2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.VideoView;
import static com.example.spaceman2.MainActivity2.sekunde;

import static com.example.spaceman2.MainActivity2.novac;
public class MainActivity3 extends AppCompatActivity {
    private static final String FILE_NAME = "text.txt";
    private static final String NOVAC = "novac.txt";
    public static int ukupan_novac;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        IOclass olovka = new IOclass(this);
        VideoView videoView = findViewById(R.id.fullScreenVideoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pozadina3;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        Boolean prvi_put = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("prvi_put", true);
        if(prvi_put)
        {
            olovka.sacuvaj(0,NOVAC);
            olovka.sacuvaj(0,FILE_NAME);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("prvi_put", false).commit();
        }
        TextView Tnajbolji = findViewById(R.id.najbolji);
        TextView skor = findViewById(R.id.zapravo_skor);
        TextView SKOR = findViewById(R.id.tekst); // samo tekst skor,ne zapravo broj
        SKOR.setText("SCORE: ");
        skor.setText(Integer.toString(sekunde));
        TextView gejm_over = findViewById(R.id.game_over);
        gejm_over.setText("GAME OVER");
        ukupan_novac = Integer.parseInt(olovka.ucitaj(NOVAC)) + novac;
        olovka.sacuvaj(ukupan_novac,NOVAC);
        TextView Tnovac = findViewById(R.id.zapravo_novac);
        Tnovac.setText(Integer.toString(ukupan_novac));
        int najbolji = Integer.parseInt(olovka.ucitaj(FILE_NAME));
        if(najbolji < sekunde)
        {
            olovka.sacuvaj(sekunde, FILE_NAME);
            Tnajbolji.setText(Integer.toString(sekunde));
        }
        else
        {
            Tnajbolji.setText(Integer.toString(najbolji));
        }

    }
    public void restart(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }
    public void pocetna(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
