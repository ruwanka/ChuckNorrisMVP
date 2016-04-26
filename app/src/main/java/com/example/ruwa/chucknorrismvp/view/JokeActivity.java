package com.example.ruwa.chucknorrismvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ruwa.chucknorrismvp.R;
import com.example.ruwa.chucknorrismvp.model.Joke;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Joke joke = getIntent().getParcelableExtra("joke");
        ((TextView)findViewById(R.id.txtjoke)).setText(joke.getJoke());
    }
}
