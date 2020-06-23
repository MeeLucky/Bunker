package com.example.bunker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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

        int gray = getResources().getColor(R.color.white);

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
        if(card.mask[9]) {
            tv.setTextColor(getResources().getColor(R.color.gray));
            tv.setEnabled(false);
            ((TextView)findViewById(R.id.card_skill1_title)).setTextColor(gray);
        }

        tv = findViewById(R.id.card_skill2);
        tv.setText(card.getSkill2());
        if(card.mask[10]) {
            tv.setTextColor(gray);
            tv.setEnabled(false);
            ((TextView)findViewById(R.id.card_skill2_title)).setTextColor(gray);
        }
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

    public void skillClick(View view) {
        final TextView desk;
        final boolean isFirst = view.getTag().toString().equals("1");
        if(isFirst)
            desk = findViewById(R.id.card_skill1);
        else
            desk = findViewById(R.id.card_skill2);


       Snackbar.make(view, "Использовать карту "+desk.getTag().toString()+"?", Snackbar.LENGTH_LONG)
               .setActionTextColor(getResources().getColor(R.color.colorPrimary))
               .setTextColor(getResources().getColor(R.color.white))
               .setAction("ДА", new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(useSkill(desk.getText().toString(), isFirst)) {
                           markSkill(isFirst);
                       }
                   }
               })
               .show();
    }

    private void markSkill(boolean isFirst) {
        final TextView title, desk;
        final int id;
        if(isFirst) {
            id = 9;
            title = findViewById(R.id.card_skill1_title);
            desk = findViewById(R.id.card_skill1);
        } else {
            id = 10;
            title = findViewById(R.id.card_skill2_title);
            desk = findViewById(R.id.card_skill2);
        }
        title.setTextColor(getResources().getColor(R.color.gray));
        desk.setTextColor(getResources().getColor(R.color.gray));
        desk.setEnabled(false);
        card.mask[id] = true;
    }

    private boolean useSkill(String skillDesk, boolean isFirst) {
        switch (skillDesk) {
            case "сменить себе профессию":
                card.setProfession(bunker.data.getProfession());
                break;

            case "сменить себе фобию":
                card.setPhobia(bunker.data.getPhobia());
                break;

            case "сменить себе хобби":
                card.setHobby(bunker.data.getHobby());
                break;

            case "сменить себе багаж":
                card.setBaggage(bunker.data.getBaggage());
                break;

            case "сменить себе здоровье":
                card.setHealth(bunker.data.getHealth());
                break;

            case "сменить проффесии всех игроков":
                for(Card item : bunker.getCards()) {
                    item.setProfession(bunker.data.getProfession());
                }
                break;

            case "сменить профессии всех игроков по часовой":
                Card[] cards = bunker.getCards();
                String prof = "";
                for(Card item : cards) {
                    if(item.isAlive()) {
                        String tmp = item.getProfession();
                        item.setProfession(prof);
                        prof = tmp;
                    }
                }
                for(Card item : cards) {
                    if(item.isAlive()) {
                        item.setProfession(prof);
                        break;
                    }
                }
                break;

            case "вылечить себя от любых недугов (фобия и здоровье)":
                card.setHealth("Полностью здоров");
                card.setPhobia("нет фобий");
                break;

            case "обменять богаж с любым игроком":
                chosePlayer("baggage", "steal", isFirst);
                return false;

            case "обменять хобби с любым игроком":
                chosePlayer("hobby", "steal", isFirst);
                return false;

            case "изменить профессию любого игрока":
                chosePlayer("profession", "change", isFirst);
                return false;

            case "изменить фобию любого игрока":
                chosePlayer("phobia", "change", isFirst);
                return false;

            case "изменить хобби любого игрока":
                chosePlayer("hobby", "change", isFirst);
                return false;

            case "изменить здоровье любого игрока":
                chosePlayer("health", "change", isFirst);
                return false;

            case "изменить багаж любого игрока":
                chosePlayer("baggage", "change", isFirst);
                return false;

            case "вылечить любого игрока от любых недугов (фобия и здоровье)":
                chosePlayer("phobia health", "heal", isFirst);
                return false;

            case "вылечить бесплодие любого игрока":
                chosePlayer("childfree", "heal", isFirst);
                return false;

            default:
                Toast.makeText(this, "Устно объявите об использовании карты", Toast.LENGTH_LONG).show();
                return true;
        }

        this.recreate();
        return true;
    }

    private void chosePlayer(String item, String action, boolean isFirst) {
        Intent intent = new Intent(this, ChosePlayer.class);
        intent.putExtra("id1", card.getId());
        intent.putExtra("action", action);
        intent.putExtra("item", item);
        intent.putExtra("isFirst", isFirst);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                int id1 = data.getIntExtra("id1", -1);
                int id2 = data.getIntExtra("id2", -1);
                Card p1 = bunker.getCard(id1);
                Card p2 = bunker.getCard(id2);
                String item = data.getStringExtra("item");
                String action = data.getStringExtra("action");
                if(action.equals("steal")) {
                    String tmp1, tmp2;
                    switch (item) {
                        case "baggage":
                            tmp1 = p1.getBaggage();
                            tmp2 = p2.getBaggage();
                            p1.setBaggage(tmp2);
                            p2.setBaggage(tmp1);
                            break;
                        case "hobby":
                            tmp1 = p1.getHobby();
                            tmp2 = p2.getHobby();
                            p1.setHobby(tmp2);
                            p2.setHobby(tmp1);
                            break;
                        case "health":
                            tmp1 = p1.getHealth();
                            tmp2 = p2.getHealth();
                            p1.setHealth(tmp2);
                            p2.setHealth(tmp1);
                            break;
                    }
                }
                if(action.equals("change")) {
                    switch (item) {
                        case "profession":
                            p2.setProfession(bunker.data.getProfession());
                            break;
                        case "baggage":
                            p2.setBaggage(bunker.data.getBaggage());
                            break;
                        case "health":
                            p2.setHealth(bunker.data.getHealth());
                            break;
                        case "hobby":
                            p2.setHobby(bunker.data.getHobby());
                            break;
                        case "phobia":
                            p2.setPhobia(bunker.data.getPhobia());
                            break;
                    }
                }
                if(action.equals("heal")) {
                    if(item.equals("phobia health")) {
                        p2.setHealth("полностью здоров");
                        p2.setPhobia("нет фобий");
                    }
                    if(item.equals("childfree"))
                        p2.setChilefree(false);
                }
                this.recreate();
                markSkill(data.getBooleanExtra("isFirst", true));
            }
        else
            super.onActivityResult(requestCode, resultCode, data);
    }
}