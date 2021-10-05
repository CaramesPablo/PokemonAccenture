package com.pablo.pokemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pablo.pokemon.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView pokemon_view;
    private TextView pokemon_data;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        pokemon_data = (TextView) itemView.findViewById(R.id.pokemon_data);
        pokemon_view = (ImageView) itemView.findViewById(R.id.pokemon_pixelart);
    }
    public ImageView getPokemon_view(){
        return pokemon_view;
    }

    public TextView getPokemon_id() {return pokemon_data; }
}
