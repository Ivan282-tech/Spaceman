package com.example.spaceman2;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOclass {
    private Context context;
    public IOclass(Context context)
    {
        this.context = context;
    }
    public void sacuvaj(int vrednost, String fajl)
    {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fajl, context.MODE_PRIVATE);
            fos.write(Integer.toString(vrednost).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String ucitaj(String fajl)
    {
        FileInputStream fis = null;

        try {
            fis = context.openFileInput(fajl);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
                return text;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return " ";
    }

}
