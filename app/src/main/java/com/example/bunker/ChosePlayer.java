package com.example.bunker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ChosePlayer extends AppCompatActivity {

    Bunker bunker;
    int id1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chose_player);
        getSupportActionBar().hide();

        Bundle extras = getIntent().getExtras();
        final boolean isFirst = extras.getBoolean("isFirst");
        final String item = extras.getString("item");
        String question = extras.getString("msg");
        id1 = extras.getInt("id1");
        TextView TVquestion = findViewById(R.id.question);
        TVquestion.setText(question);

        bunker = Singleton.getBunker();

        CardAdapter cardAdapter = new CardAdapter(this, R.layout.card_list_view, bunker.getCards());
        final ListView choseList = findViewById(R.id.chose_list);
        choseList.setAdapter(cardAdapter);

        choseList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if(bunker.getCard(position).isAlive()) {
                    Intent intent = new Intent();
                    intent.putExtra("id1", id1);
                    intent.putExtra("id2", bunker.getCard(position).getId());
                    intent.putExtra("isFirst", isFirst);
                    intent.putExtra("item", item);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    public void back(View view) {
        this.finish();
    }
}