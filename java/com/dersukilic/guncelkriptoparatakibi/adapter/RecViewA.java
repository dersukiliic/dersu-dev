package com.dersukilic.guncelkriptoparatakibi.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dersukilic.guncelkriptoparatakibi.R;
import com.dersukilic.guncelkriptoparatakibi.model.KriptoModel;

import java.util.ArrayList;

public class RecViewA extends RecyclerView.Adapter<RecViewA.RowHolder> {

    private  String[] colors = {"#cd919e","#83adb5"};
    private ArrayList<KriptoModel> kriptoListe;


    public RecViewA(ArrayList<KriptoModel> kriptoListe) {
        this.kriptoListe = kriptoListe;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(kriptoListe.get(position),colors, position);
    }


    @Override
    public int getItemCount() {
        return kriptoListe.size();
    }


    public class RowHolder extends RecyclerView.ViewHolder {
        TextView textIsim;
        TextView textFiyat;


        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(KriptoModel kriptoModel, String[] colors, Integer position) {

            itemView.setBackgroundColor(Color.parseColor(colors[position % 2]));
            textIsim = itemView.findViewById(R.id.text_isim);
            textFiyat = itemView.findViewById(R.id.text_fiyat);
            textIsim.setText(kriptoModel.currency);
            textFiyat.setText(kriptoModel.price);
        }



    }
}
