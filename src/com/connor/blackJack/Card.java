package com.connor.blackJack;


public class Card {
    public enum Suit {
        Club (0), Diamond (1), Heart (2), Spade(3);
        private final int value;
        Suit(int v) { value = v;}
        public int getValue() { return value;}
        public static Suit getSuitFromValue(int value) { return Suit.values()[value]; }
    }
    public enum Value {
        Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9),
        Ten(10), Jack(11), Queen(12), King(13);
        private final int value;
        Value(int v) {value = v;}
        public int getValue() { return value; }
        public static Value getValueFromInt(int value) { return Value.values()[value-1];}
    }

    private final Suit mSuit;
    private final Value mValue;
    public Card(Suit suit, Value val) {
        mSuit = suit;
        mValue = val;
    }
    public Suit getSuit() {
        return mSuit;
    }
    public Value getValue() {
        return mValue;
    }
    public String getCardString() {
        return mValue + " of " + mSuit + "s";
    }
    public boolean equals(Card compare) {
        return mValue == compare.getValue() && mSuit == compare.getSuit();
    }
}
