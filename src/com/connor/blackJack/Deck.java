package com.connor.blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> mCards = new ArrayList<>();
    int mDealtIndex;
    public Deck(){
        mDealtIndex = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                mCards.add(new Card(suit, value));

            }
        }
    }
    public void shuffle() {
        Card temp;
        Random rand = new Random();
        //take the current position and a random position and switch them.
        for (int i = 0; i < mCards.size(); i++) {
            int newPlace = rand.nextInt(52);
            temp = mCards.get(i);
            mCards.add(i, mCards.get(newPlace));
            mCards.remove(i+1);
            mCards.add(newPlace, temp);
            mCards.remove(newPlace+1);
        }
        mDealtIndex = 0;
    }
    public Card deal() {
        Card ret = mCards.get(mDealtIndex);
        mDealtIndex++;
        return ret;

    }
    public void printDeck() {

        for (Card mCard : mCards) {
            System.out.println(mCard.getValue() + " of " + mCard.getSuit() + "s");
        }
    }
}
