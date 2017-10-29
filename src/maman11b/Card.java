/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman11b;

import java.util.Objects;

/**
 *
 * @author elira
 */
public class Card {
    private final CardRank cardRank;
    private final CardSuit cardSuit;
    
    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }
    
    public int getValue() {
        return cardRank.getValue();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.cardRank);
        hash = 89 * hash + Objects.hashCode(this.cardSuit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Card other = (Card) obj;
        
        return this.cardRank == other.cardRank && this.cardSuit == other.cardSuit;
    }
    
    
}
