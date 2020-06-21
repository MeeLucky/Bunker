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
    Card card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.card_reader);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        Bundle extr = intent.getExtras();
        int position = extr.getInt("position");
        card = bunker.getCard(position);

        TextView tv = findViewById(R.id.card_gender_age);
        String gender_age = "";
        gender_age += Objects.requireNonNull(card).getGender() ? "М. " : "Ж. ";
        gender_age += card.getAge();
        tv.setText(gender_age);
        if(card.mask[0])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_childfree);
        tv.setText(card.getChildfree() ? "да" : "нет");
        if(card.mask[1])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_profession);
        tv.setText(card.getProfession());
        if(card.mask[2])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_health);
        tv.setText(card.getHealth());
        if(card.mask[3])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_phobia);
        tv.setText(card.getPhobia());
        if(card.mask[4])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_character);
        tv.setText(card.getCharacter());
        if(card.mask[5])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_hobby);
        tv.setText(card.getHobby());
        if(card.mask[6]) {
            tv.setTextColor(getResources().getColor(R.color.gray));
        }

        tv = findViewById(R.id.card_info);
        tv.setText(card.getInfo());
        if(card.mask[7])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_baggage);
        tv.setText(card.getBaggage());
        if(card.mask[8])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_skill1);
        tv.setText(card.getSkill1());
        if(card.mask[9])
            tv.setTextColor(getResources().getColor(R.color.gray));

        tv = findViewById(R.id.card_skill2);
        tv.setText(card.getSkill2());
        if(card.mask[10])
            tv.setTextColor(getResources().getColor(R.color.gray));
    }

    public void back(View view) {
        this.finish();
    }

    public void mark(View view) {
        TextView tv = (TextView)view;
        int pos = Integer.parseInt(tv.getTag().toString());
        tv.setTextColor(getResources().getColor(R.color.gray));
        card.mask[pos] = true;
    }
}