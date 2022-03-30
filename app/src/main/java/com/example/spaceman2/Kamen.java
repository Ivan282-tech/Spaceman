package com.example.spaceman2;

public class Kamen {

    private float y;
    private  float x;
    private float pomeraj = 5;
    private MainActivity2 aktiviti = new MainActivity2();
    private float visina = aktiviti.vratiDimenzije().getA();
    private float sirina = aktiviti.vratiDimenzije().getB();
    public Kamen()
    {
        this.y = -70;
        this.x = nasumicni();
    }
    private float nasumicni()
    {
        float opseg = (sirina - 30) + 30;
        return (float)(Math.random() * opseg) + 30;

    }
    public Rezultat padanje()
    {
        if(aktiviti.getZiv())
        {
            if(y >= visina)
            {
                y = -70;
                x = nasumicni();
            }
            y = y + pomeraj;
        }

        return new Rezultat(x,y);
    }

    public void ubrzaj()
    {
        pomeraj += 0.2;
    }
    public float getY()
    {
        return y;
    }
    public float getX()
    {
        return x;
    }
    public void setXY(){
        this.x = -70;
        this.y = nasumicni();
    }






}
