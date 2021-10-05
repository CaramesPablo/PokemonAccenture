package com.pablo.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;


/** Vista del JSON sin refinar solo recoger datos
 *
 */

public class Layout1 extends AppCompatActivity {

    private String api_url = "https://run.mocky.io/v3/6330d6b0-17ff-4e87-9eb4-fef4922817d8";
    private Button back_button;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        back_button = (Button) findViewById(R.id.back_button);
        info = (TextView) findViewById(R.id.info);
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest json = new JsonArrayRequest
                (Request.Method.GET, api_url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response){
                        String datos = "";
                        datos = response.toString();
                        info.setText(datos);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
                );
        queue.add(json);

    }

    public void onClick(View view) {
        if(view.getId() == R.id.back_button){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


}




