/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman11b;

/**
 *
 * @author elira
 */
public enum CardRank {
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (10),
    QUEEN (10),
    KING (10),
    ACE (1);
    
    private final int value;
    
    CardRank(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
