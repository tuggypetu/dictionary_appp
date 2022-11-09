package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class WordExplanationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        setContentView(R.layout.activity_word_explanation);

        TextView meaningText = findViewById(R.id.meaningText);
        TextView word = findViewById(R.id.word);
        String wordData = getIntent().getStringExtra("word");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        word.setText(wordData);
        meaningText.setText(databaseAccess.getMeaning(wordData));
        databaseAccess.close();

    }
}