package com.pablo.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button layout1_button;
    private Button layout2_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1_button = (Button) findViewById(R.id.layout1_button);
        layout2_button = (Button) findViewById(R.id.layout2_button);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.layout1_button){
            Intent intent = new Intent(this, Layout1.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Layout2.class);
            startActivity(intent);
        }

    }
}