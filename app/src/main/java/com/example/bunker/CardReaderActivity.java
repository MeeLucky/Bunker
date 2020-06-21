package com.example.bunker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class CardReaderActivity extends AppCompatActivity {

    Bunker bunker = Singleton.getBunker();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.card_reader);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        Bundle extr = intent.getExtras();
        int position = extr.getInt("position");
        Card card = bunker.getCard(position);

        TextView tv = findViewById(R.id.card_gender_age);
        String gender_age = "";
        gender_age += Objects.requireNonNull(card).getGender() ? "М. " : "Ж. ";
        gender_age += card.getAge();
        tv.setText(gender_age);

        tv = findViewById(R.id.card_childfree);
        tv.setText(card.getChildfree() ? "да" : "нет");

        tv = findViewById(R.id.card_profession);
        tv.setText(card.getProfession());

        tv = findViewById(R.id.card_hobby);
        tv.setText(card.getHobby());

        tv = findViewById(R.id.card_phobia);
        tv.setText(card.getPhobia());

        tv = findViewById(R.id.card_baggage);
        tv.setText(card.getBaggage());

        tv = findViewById(R.id.card_character);
        tv.setText(card.getCharacter());

        tv = findViewById(R.id.card_info);
        tv.setText(card.getInfo());

        tv = findViewById(R.id.card_health);
        tv.setText(card.getHealth());

        tv = findViewById(R.id.card_skill1);
        tv.setText(card.getSkill1());

        tv = findViewById(R.id.card_skill2);
        tv.setText(card.getSkill2());
    }

    public void back(View view) {
        this.finish();
    }
}