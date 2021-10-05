package com.pablo.pokemon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/** JSON recogido y refinado en un display con un cardview cada elemento
 *
 */

public class Layout2 extends AppCompatActivity {

    private String api_url = "https://run.mocky.io/v3/6330d6b0-17ff-4e87-9eb4-fef4922817d8";
    private String asset_url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

    private Button back_button;

    private String pokemon_id;
    private String pokemon_name;

    private Context nice_display = this;
    private RecyclerView pokemon_display;
    private Adapter pokemon_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        back_button = (Button) findViewById(R.id.back_button);
        RequestQueue queue = Volley.newRequestQueue(this);
        pokemon_display = (RecyclerView) findViewById(R.id.display);

        JsonArrayRequest pokemon_request = new JsonArrayRequest
                (Request.Method.GET, api_url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<PokemonDTO> pokemons = new LinkedList<>();
                        String final_url = "";
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject pokemon_data = response.getJSONObject(i);
                                pokemon_id = pokemon_data.getString("id");
                                pokemon_name = pokemon_data.getString("name");
                                final_url = asset_url + pokemon_id + ".png";
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            PokemonDTO for_this_cell = new PokemonDTO(pokemon_id, final_url, pokemon_name);
                            pokemons.add(for_this_cell);
                        }
                        pokemon_adapter = new Adapter(pokemons, nice_display);

                        pokemon_display.setAdapter(pokemon_adapter);
                        pokemon_display.setLayoutManager(new GridLayoutManager(nice_display, 1));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
                );
        queue.add(pokemon_request);

    }

    public void onClick(View view) {
        if(view.getId() == R.id.back_button2){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}




