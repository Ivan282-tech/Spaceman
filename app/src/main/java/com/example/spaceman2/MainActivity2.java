package com.example.spaceman2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.BuildConfig;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MotionEvent;
import java.util.Timer;
import java.util.TimerTask;
import static com.example.spaceman2.MainActivity.player;

public class MainActivity2 extends AppCompatActivity {
    MyCanvas kanvas;
    static Igrac igrac = new Igrac();
    static int sekunde = 0;
    static int novac = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        novac = 0;
        if(BuildConfig.DEBUG)
            StrictMode.enableDefaults();
        igrac.setZiv(true);
        //player = MediaPlayer.create(this,  R.raw.spaceman);
        //player.setLooping(true);
        //player.start();
        kanvas = new MyCanvas(this);
        setContentView(kanvas);
        int n = randomBroj();
        switch(n)
        {
            case 1: kanvas.setBackgroundResource(R.drawable.r_1); break;
            case 2: kanvas.setBackgroundResource(R.drawable.r_2); break;
            case 3: kanvas.setBackgroundResource(R.drawable.r_3); break;
            case 4: kanvas.setBackgroundResource(R.drawable.r_4); break;
        }
        sekunde = 0;
        igrac.setZiv(true);
        vreme();
    }

    public void vreme()
    {
        Timer timer = new Timer();
          TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if(igrac.getZiv())
                    {
                        sekunde++;
                    }
                    else {
                        timer.cancel();
                        igrac.setX(vratiDimenzije().getA() / 4);
                        igrac.setY(2100);
                        finish();
                    }
                }
            };
            timer.schedule(timerTask, 0,1000);
        }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        igrac.setX(event.getX());
        igrac.setY(event.getY());
        return false;
    }
    public float vratiX()
    {
        return igrac.getX();
    }
    public boolean getZiv()
    {
        return igrac.getZiv();
    }
    public float vratiY()
    {
        return igrac.getY();
    }
    public void setZiv(boolean vrednost)
    {
        igrac.setZiv(vrednost);
    }
   public Rezultat vratiDimenzije()
    {
            int visina = Resources.getSystem().getDisplayMetrics().heightPixels;
            int sirina = Resources.getSystem().getDisplayMetrics().widthPixels;
            return new Rezultat(visina,sirina);// A i B
    }
    private int randomBroj()
    {
        float broj = (4 - 1) + 1;
        return (int)(Math.random() * broj) + 1;
    }
}