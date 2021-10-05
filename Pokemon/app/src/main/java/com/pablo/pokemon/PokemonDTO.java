package com.pablo.pokemon;

public class PokemonDTO {
    private String pokemon_id;
    private String asset_url;
    private String pokemon_name;

    public PokemonDTO(String pokemon_id, String asset_url, String pokemon_name) {
        this.pokemon_id = pokemon_id;
        this.pokemon_name = pokemon_name;
        this.asset_url = asset_url;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public String getPokemon_id() {
        return pokemon_id;
    }

    public String getAsset_url() {
        return asset_url;
    }
}
