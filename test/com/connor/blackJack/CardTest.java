package com.connor.blackJack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    static Card testCard;

    @BeforeAll
    static void setup() {
        testCard = new Card(Card.Suit.Club, Card.Value.Ace);
    }
    @Test
    void getSuit() {
        Assertions.assertEquals(Card.Suit.Club, testCard.getSuit());
    }

    @Test
    void getValue() {
        Assertions.assertEquals(Card.Value.Ace, testCard.getValue());
    }

    @Test
    void printCard() {
        Assertions.assertEquals("Ace of Clubs", testCard.getCardString());
    }

    @Test
    void suitAndValue() {
        Assertions.assertEquals(Card.Suit.values()[0], Card.Suit.Club);
        Assertions.assertEquals(Card.Suit.values()[1], Card.Suit.Diamond);
        Assertions.assertEquals(Card.Suit.values()[2], Card.Suit.Heart);
        Assertions.assertEquals(Card.Suit.values()[3], Card.Suit.Spade);

        Assertions.assertEquals(Card.Value.values()[0], Card.Value.Ace);
        Assertions.assertEquals(Card.Value.values()[1], Card.Value.Two);
        Assertions.assertEquals(Card.Value.values()[2], Card.Value.Three);
        Assertions.assertEquals(Card.Value.values()[3], Card.Value.Four);
        Assertions.assertEquals(Card.Value.values()[4], Card.Value.Five);
        Assertions.assertEquals(Card.Value.values()[5], Card.Value.Six);
        Assertions.assertEquals(Card.Value.values()[6], Card.Value.Seven);
        Assertions.assertEquals(Card.Value.values()[7], Card.Value.Eight);
        Assertions.assertEquals(Card.Value.values()[8], Card.Value.Nine);
        Assertions.assertEquals(Card.Value.values()[9], Card.Value.Ten);
        Assertions.assertEquals(Card.Value.values()[10], Card.Value.Jack);
        Assertions.assertEquals(Card.Value.values()[11], Card.Value.Queen);
        Assertions.assertEquals(Card.Value.values()[12], Card.Value.King);

    }
}