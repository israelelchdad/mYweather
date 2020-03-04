package com.example.weather.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.weather.Moudel.Country;
import com.example.weather.R;

import java.util.ArrayList;

public class AdapterOfallCountries extends RecyclerView.Adapter<AdapterOfallCountries.ViewHolder> {
    private final Context mContext;
    ArrayList<Country> allCountry;
    private OnClicMoveCountry onClicMoveCountry;

    public AdapterOfallCountries(ArrayList<Country> allCountry, Context context,OnClicMoveCountry onClicMoveCountry) {
        this.allCountry = allCountry;
        mContext = context;
        this.onClicMoveCountry = onClicMoveCountry;
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
        ImageView myImageView;
        Country myCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCountry = itemView.findViewById(R.id.Text_of_nameCountry);
            nameRegin = itemView.findViewById(R.id.Text_of_regin);
            myImageView = itemView.findViewById(R.id.item_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClicMoveCountry.MoveContry(myCountry);
                }
            });

        }


        public void setHolder(Country contry){
            myCountry = contry;
            nameCountry.setText(contry.getName());
            nameRegin.setText(contry.getRegion());

            SvgLoader.pluck()
                    .with((Activity) mContext)
                    .load(contry.getFlag(), myImageView);
//            Picasso.get().load(myContry.getFlag()).into(myImageView);




        }

    }
    public interface OnClicMoveCountry{
        void MoveContry(Country myCountry);
    }
}
