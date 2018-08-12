package com.example.jokesdisplayandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesDisplayActivity extends AppCompatActivity{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokesdisplay);
        textView = (TextView) findViewById(R.id.joke_text);
        textView.setText(getIntent().getStringExtra(getString(R.string.jokes)));
    }
}
