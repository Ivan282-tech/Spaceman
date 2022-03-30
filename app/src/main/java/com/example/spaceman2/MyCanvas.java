package com.example.spaceman2;





import static com.example.spaceman2.MainActivity.player;
import static com.example.spaceman2.MainActivity2.sekunde;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import static com.example.spaceman2.MainActivity2.novac;
public class MyCanvas extends View
{
    Bitmap brod, protivnik, zvezda;
    float minusX = 90, minusY = 85;
    float minusXB = 80, minusYB = 200;
    Kamen kamen = new Kamen();
    Kamen kamen1 = new Kamen();
    Kamen kamen2 = new Kamen();
    Kamen kamen3 = new Kamen();
    Kamen kamen4 = new Kamen();
    Kamen kamen5 = new Kamen();
    Kamen zvezdica = new Kamen();
    static MainActivity2 aktiviti = new MainActivity2();
    public MyCanvas(Context context) {
        super(context);
        brod = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
        protivnik = BitmapFactory.decodeResource(getResources(), R.drawable.kamen);
        zvezda = BitmapFactory.decodeResource(getResources(), R.drawable.star);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if(aktiviti.getZiv()) {
            canvas.drawBitmap(brod, aktiviti.vratiX() - minusXB, aktiviti.vratiY() - minusYB, null);
            hitac(aktiviti.vratiX(), aktiviti.vratiY(), kamen.padanje().getA(), kamen.padanje().getB(), false);
            canvas.drawBitmap(protivnik, kamen.padanje().getA() - minusX, kamen.padanje().getB() - minusY, null);
            if (sekunde > 3) {
                canvas.drawBitmap(protivnik, kamen1.padanje().getA() - minusX, kamen1.padanje().getB() - minusY, null);
                hitac(aktiviti.vratiX(), aktiviti.vratiY(), kamen1.padanje().getA(), kamen1.padanje().getB(), false);
                canvas.drawBitmap(zvezda, zvezdica.padanje().getA() - minusX, zvezdica.padanje().getB() - minusY, null);
                hitac(aktiviti.vratiX(), aktiviti.vratiY(), zvezdica.padanje().getA(), zvezdica.padanje().getB(), true);
            }
            if (sekunde > 6) {
                canvas.drawBitmap(protivnik, kamen2.padanje().getA() - minusX, kamen2.padanje().getB() - minusY, null);
                hitac(aktiviti.vratiX(), aktiviti.vratiY(), kamen2.padanje().getA(), kamen2.padanje().getB(), false);
            }
            if (sekunde > 9) {
                canvas.drawBitmap(protivnik, kamen3.padanje().getA() - minusX, kamen3.padanje().getB() - minusY, null);
                hitac(aktiviti.vratiX(), aktiviti.vratiY(), kamen3.padanje().getA(), kamen3.padanje().getB(), false);
            }
            if (sekunde > 12) {
                canvas.drawBitmap(protivnik, kamen4.padanje().getA() - minusX, kamen4.padanje().getB() - minusY, null);
                hitac(aktiviti.vratiX(), aktiviti.vratiY(), kamen4.padanje().getA(), kamen4.padanje().getB(), false);
            }
            if (sekunde > 15) {
                canvas.drawBitmap(protivnik, kamen5.padanje().getA() - minusX, kamen5.padanje().getB() - minusY, null);
                hitac(aktiviti.vratiX(), aktiviti.vratiY(), kamen5.padanje().getA(), kamen5.padanje().getB(), false);

            }
            invalidate();
        }

    }
    private void hitac(float x_brod, float y_brod, float x_kamen, float y_kamen, boolean Z)
    {

        double d = Math.sqrt((x_kamen - x_brod) * (x_kamen - x_brod) + (y_kamen - y_brod) * (y_kamen - y_brod));
        if(!Z)
        {
            if(d <= 80){
                aktiviti.setZiv(false);
                Intent in = new Intent(((MainActivity2)getContext()),MainActivity3.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((MainActivity2)getContext()).startActivity(in);
                ((Activity)(MainActivity2)getContext()).finish();
                if(player.isPlaying())
                {
                    player.stop();
                }

            }
        }
        else if(Z)
        {
            if(d <= 100){
               novac++;
               this.zvezdica.setXY();
            }
        }

    }
}

