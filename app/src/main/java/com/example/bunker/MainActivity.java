package com.example.bunker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Bunker bunker;

    public void createCards(View view) {
        EditText etPlayerCount = findViewById(R.id.et_player_count);
        int playerCount = Integer.parseInt(etPlayerCount.getText().toString());
        bunker = new Bunker(playerCount);
        ArrayAdapter<Card> cardAdapter = new CardAdapter(this, R.layout.card_list_view, bunker.getCards());
        ListView cardList = findViewById(R.id.cards_list);
        cardList.setAdapter(cardAdapter);
    }
}
