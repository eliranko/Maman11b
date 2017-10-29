/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman11b;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author elira
 */
public class Deck {
    private final Stack<Card> cardsDeck = new Stack<>();
    
    public Deck() {
        initDeck();
    }
    
    public void shuffle() {
        Collections.shuffle(cardsDeck);
    }
    
    public Card getNextCard() {
        return cardsDeck.pop();
    }
    
    private void initDeck() {
        for (CardRank rank : CardRank.values()) {
            for (CardSuit suit : CardSuit.values()) {
                cardsDeck.add(new Card(rank, suit));
            }
        }
    }
}
