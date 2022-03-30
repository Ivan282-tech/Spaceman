package com.example.spaceman2;


public class Igrac{

    private float x;
    private float y;
    private boolean ziv;
    public Igrac()
    {
            MainActivity2 dimenzije = new MainActivity2();
            x = dimenzije.vratiDimenzije().getA() / 4;
            //y = dimenzije.vratiDimenzije().getB() - 100;
            y = 2100;
            ziv = true;
    }
    public float getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }
    public boolean getZiv()
    {
        return ziv;
    }
    public void setX(float x)
    {
        this.x = x;
    }
    public void setY(float y)
    {
        this.y = y;
    }
    public void setZiv(boolean ziv)
    {
        this.ziv = ziv;
    }





}
