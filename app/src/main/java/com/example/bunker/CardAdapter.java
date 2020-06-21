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
    private Context context;

    public CardAdapter(Context context, int resource, Card[] cards) {
        super(context, resource, cards);
        this.cards = cards;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView id = view.findViewById(R.id.tv_id);
        TextView name = view.findViewById(R.id.tv_name);
        TextView isAlive = view.findViewById(R.id.tv_is_alive);

        Card card = cards[position];


        int gray = context.getResources().getColor(R.color.white);
        int red = context.getResources().getColor(R.color.red);
        
        id.setText(String.valueOf(card.getId()));
        id.setTextColor(card.isAlive() ? gray : red);

        name.setText(card.getProfession());
        name.setTextColor(card.isAlive() ? gray : red);

        isAlive.setText(card.isAlive() ? "alive" : "death");
        isAlive.setTextColor(card.isAlive() ? gray : red);

        return view;
    }
}
