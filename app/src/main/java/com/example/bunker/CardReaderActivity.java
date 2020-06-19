package com.example.bunker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class CardReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.card_reader);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        Bundle extr = intent.getExtras();
        int age = Objects.requireNonNull(extr).getInt("age");
        boolean gender = Objects.requireNonNull(extr).getBoolean("gender");
        boolean childfree = Objects.requireNonNull(extr).getBoolean("childfree");
        String profession = Objects.requireNonNull(extr).getString("profession");
        String phobia = Objects.requireNonNull(extr).getString("phobia");
        String character = Objects.requireNonNull(extr).getString("character");
        String health = Objects.requireNonNull(extr).getString("health");
        String baggage = Objects.requireNonNull(extr).getString("baggage");
        String hobby = Objects.requireNonNull(extr).getString("hobby");
        String info = Objects.requireNonNull(extr).getString("info");
        String skill1 = Objects.requireNonNull(extr).getString("skill1");
        String skill2 = Objects.requireNonNull(extr).getString("skill2");


        TextView tv = findViewById(R.id.card_gender_age);
        String gender_age = "";
        gender_age += gender ? "М. " : "Ж. ";
        gender_age += age;
        tv.setText(gender_age);

        tv = findViewById(R.id.card_childfree);
        tv.setText(childfree ? "да" : "нет");

        tv = findViewById(R.id.card_profession);
        tv.setText(profession);

        tv = findViewById(R.id.card_hobby);
        tv.setText(hobby);

        tv = findViewById(R.id.card_phobia);
        tv.setText(phobia);

        tv = findViewById(R.id.card_baggage);
        tv.setText(baggage);

        tv = findViewById(R.id.card_character);
        tv.setText(character);

        tv = findViewById(R.id.card_info);
        tv.setText(info);

        tv = findViewById(R.id.card_health);
        tv.setText(health);

        tv = findViewById(R.id.card_skill1);
        tv.setText(skill1);

        tv = findViewById(R.id.card_skill2);
        tv.setText(skill2);
    }
}