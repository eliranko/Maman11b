/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman11b;

import java.util.ArrayList;

/**
 *
 * @author elira
 */
public class Gambler {
    private final ArrayList<Card> cards;
    
    public Gambler() {
        cards = new ArrayList<>();
    }
    
    public void clean() {
        cards.clear();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public int getHandValue() {
        int value = 0;
        int numOfAces = 0;
        // Sum the cards except aces
        for (Card card : cards) {
            if(card.getRank() == CardRank.ACE) {
                numOfAces++;
                continue;
            }
            
            value += card.getValue();
        }

        // Sum the cards including the aces
        // If one ace with the value of 11 isn't making the hand invalid (over 21)
        // so we will use this value (11). Otherwise, it will have a value of 1.
        // All of the other aces will have the value of 1.
        if(numOfAces > 0 && value + 10 + numOfAces <= 21) {
            value += 10 + numOfAces;
        }
        else {
            value += numOfAces;
        }
        
        return value;
    }
}
