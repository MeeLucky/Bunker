package com.example.bunker;

import java.util.Random;

public class Bunker {
    //генератор карточек
    private Data data = new Data();
    private Random rand = new Random();
    private Card[] cards;

    public Bunker(int playersCount) {
        cards = new Card[playersCount];

        for(int i = 0; i < cards.length; i++) {
            cards[i] = new Card(
                    i,
                    rand.nextBoolean(),
                    18 + rand.nextInt(72),
                    data.getProfession(),
                    data.getPhobia(),
                    data.getCharacter(),
                    data.getHealth(),
                    data.getBaggage(),
                    data.getHobby(),
                    data.getInfo(),
                    data.getСhildfree(),
                    data.getSkill(),
                    data.getSkill()
            );
        }
    }

    public Card[] getCards() {
        return cards;
    }

    public Card getCard(int cardId) {
        return cards[cardId];
    }
}
