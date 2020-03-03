package com.example.weather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Moudel.Country;
import com.example.weather.R;

import java.util.ArrayList;

public class AdapterOfallCountries extends RecyclerView.Adapter<AdapterOfallCountries.ViewHolder> {
    ArrayList<Country> allCountry;

    public AdapterOfallCountries(ArrayList<Country> allCountry) {
        this.allCountry = allCountry;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.setHolder(allCountry.get(position));

    }

    @Override
    public int getItemCount() {
        return allCountry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameCountry;
        TextView nameRegin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCountry = itemView.findViewById(R.id.Text_of_nameCountry);
            nameRegin = itemView.findViewById(R.id.Text_of_regin);

        }


        public void setHolder(Country myContry){
            nameCountry.setText(myContry.getName());
            nameRegin.setText(myContry.getRegion());

        }

    }
}
