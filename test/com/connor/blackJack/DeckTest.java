package com.connor.blackJack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffle() {
        Deck testDeck1 = new Deck();
        Card cardFrom1;
        Card cardFrom2;
        Deck testDeck2 = new Deck();
        for (int i = 0; i < 52; i++) {
            cardFrom1 = testDeck1.deal();
            cardFrom2 = testDeck2.deal();
            Assertions.assertTrue(cardFrom1.equals(cardFrom2));
        }
        testDeck1.shuffle();
        testDeck2.shuffle();
        int same = 0;
        for(int i = 0; i < 52; i++) {
            cardFrom1 = testDeck1.deal();
            cardFrom2 = testDeck2.deal();
            if(cardFrom1.equals(cardFrom2)) {
                same++;
            }
        }
        if (same == 52) {
            fail("Cards were not shuffled or got shuffled into same order");
        }
    }

    @Test
    void deal() {
        Deck testDeck = new Deck();
        Assertions.assertEquals(0, testDeck.mDealtIndex);
        Card testCard = new Card(Card.Suit.Club, Card.Value.Ace);
        Assertions.assertTrue(testCard.equals(testDeck.deal()));
        Assertions.assertEquals(1, testDeck.mDealtIndex);
    }
}