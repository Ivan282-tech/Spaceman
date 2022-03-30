package com.example.spaceman2;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class Shop extends AppCompatActivity {
    private static final String FILE_NAME = "text.txt";
    private static final String NOVAC = "novac.txt";
    String[] s;
    int slike[]= {R.drawable.sputinik4, R.drawable.sputnik5, R.drawable.sputnik6, R.drawable.sputnik7, R.drawable.sputnik8};
    RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        IOclass olovka = new IOclass(this);
        Boolean prvi_put = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("prvi_put", true);
        if(prvi_put)
        {
            olovka.sacuvaj(0,NOVAC);
            olovka.sacuvaj(0,FILE_NAME);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("prvi_put", false).commit();
        }
        TextView novac = findViewById(R.id.prikaz_novca);
        String ukupan_novac = olovka.ucitaj("novac.txt");
        novac.setText(ukupan_novac);
        s = getResources().getStringArray(R.array.Avioni);
        lista = findViewById(R.id.lista);
        Adapter adapter = new Adapter(this,s, slike);
        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(this));

    }
    public void nazad_na_pocetnu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}