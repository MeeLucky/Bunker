package com.example.bunker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

                Card selectedItem = bunker.getCard(position);
                Intent intent = new Intent(MainActivity.this, CardReaderActivity.class);
                intent.putExtra("isAlive", selectedItem.isAlive());
                intent.putExtra("id", selectedItem.getId());
                intent.putExtra("gender", selectedItem.getGender());
                intent.putExtra("age", selectedItem.getAge());
                intent.putExtra("profession", selectedItem.getProfession());
                intent.putExtra("health", selectedItem.getHealth());
                intent.putExtra("character", selectedItem.getCharacter());
                intent.putExtra("phobia", selectedItem.getPhobia());
                intent.putExtra("hobby", selectedItem.getHobby());
                intent.putExtra("info", selectedItem.getInfo());
                intent.putExtra("baggage", selectedItem.getBaggage());
                intent.putExtra("childfree", selectedItem.getChildfree());
                intent.putExtra("skill1", selectedItem.getSkill1());
                intent.putExtra("skill2", selectedItem.getSkill2());

                startActivity(intent);
            }
        });
    }

    public void openCloseDisaster(View view) {
        TextView tv = findViewById(R.id.disaster);
        tv.setVisibility(tv.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }

    public void openCloseBunker(View view) {
        TextView tv = findViewById(R.id.bunker);
        tv.setVisibility(tv.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }
}
//Todo: чёрно-жёлтый стиль. Фон может быть чёрный с серой решёткой в центре.
