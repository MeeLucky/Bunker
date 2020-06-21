package com.example.bunker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    Bunker bunker;

    public void createCards(View view) {
        //hide keyboard
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(
                        getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS
                );

        EditText etPlayerCount = findViewById(R.id.et_player_count);
        int playerCount = 6;
        if(!etPlayerCount.getText().toString().isEmpty())
            playerCount= Integer.parseInt(etPlayerCount.getText().toString());
        Singleton.setBunker(playerCount);
        bunker = Singleton.getBunker();

        TextView disaster = findViewById(R.id.disaster);
        disaster.setText(Data.getDisaster());

        TextView bunkerInfo = findViewById(R.id.bunker);
        bunkerInfo.setText(Data.getBunker());

        CardAdapter cardAdapter = new CardAdapter(this, R.layout.card_list_view, bunker.getCards());
        final ListView cardList = findViewById(R.id.cards_list);
        cardList.setAdapter(cardAdapter);

        cardList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, CardReaderActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void skipMenu(View view) {
        LinearLayout ll_pc = findViewById(R.id.ll_player_count);
        ll_pc.setVisibility(ll_pc.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);

        Button create_cards = findViewById(R.id.create_cards);
        create_cards.setVisibility(create_cards.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);

        TextView disaster = findViewById(R.id.disaster);
        disaster.setVisibility(disaster.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);

        TextView bunkerBut = findViewById(R.id.bunker);
        bunkerBut.setVisibility(bunkerBut.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }
}
