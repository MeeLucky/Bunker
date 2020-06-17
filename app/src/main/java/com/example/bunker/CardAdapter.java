package com.example.bunker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private int layout;
    private Card[] cards;

    public CardAdapter(Context context, int resource, Card[] cards) {
        super(context, resource, cards);
        this.cards = cards;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView id = view.findViewById(R.id.tv_id);
        TextView name = view.findViewById(R.id.tv_name);
        TextView isAlive = view.findViewById(R.id.tv_is_alive);

        Card card = cards[position];


        id.setText(String.valueOf(card.getId()));
        name.setText(card.getProfession());
        isAlive.setText(card.isAlive() ? "alive" : "death");

        return view;
    }
}
