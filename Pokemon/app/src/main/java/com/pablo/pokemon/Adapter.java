package com.pablo.pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pablo.pokemon.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{

    private List<PokemonDTO> pokemons;
    private List<PokemonDTO> filtered_pokemons;
    private Context adapter;

    public Adapter(List<PokemonDTO> pokemons, Context adapter) {
        this.pokemons = pokemons;
        this.adapter = adapter;
        this.filtered_pokemons = pokemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.datos_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView pokemon_id_box = holder.getPokemon_id();
        ImageView pokemon_pixelart = holder.getPokemon_view();
        String name = filtered_pokemons.get(position).getPokemon_name();
        String number = "No." + filtered_pokemons.get(position).getPokemon_id();
        String data = name + " " + number;
        pokemon_id_box.setText(data);

        String image_url = filtered_pokemons.get(position).getAsset_url();
        Picasso.with(adapter).load(image_url).into(pokemon_pixelart);
    }

    @Override
    public int getItemCount() { return filtered_pokemons.size(); }
}
