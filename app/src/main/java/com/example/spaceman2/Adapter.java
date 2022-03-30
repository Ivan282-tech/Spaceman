package com.example.spaceman2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private String[] s;
    private int slike[];
    public Adapter(Context context,String s[],int slike[])
    {
        this.context = context;
        this.s = s;
        this.slike = slike;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infalter = LayoutInflater.from(context);
        View view = infalter.inflate(R.layout.red, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tekst.setText(s[position]);
            holder.slike.setImageResource(slike[position]);
    }

    @Override
    public int getItemCount() {
        return slike.length;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        TextView tekst;
        ImageView slike;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tekst = itemView.findViewById(R.id.moj_tekst);
            slike = itemView.findViewById(R.id.moja_slika);

        }
    }
}
