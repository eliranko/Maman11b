/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman11b;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author elira
 */
public class Maman11b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Gambler user = new Gambler();
        Gambler pc = new Gambler();
        
        // Deal user
        user.addCard(deck.getNextCard());
        user.addCard(deck.getNextCard());
        int reply;
        do {
            // Build message
            String message = "Your cards are: " + 
                    getStringRepresentationOfCards(user.getCards()) +
                    ". Would you like to draw?";
            
            //Ask user
            reply = JOptionPane.showConfirmDialog(null, message, "21", 
                    JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            
            if(reply == JOptionPane.YES_OPTION) {
                user.addCard(deck.getNextCard());
            }
            
        } while(reply == JOptionPane.YES_OPTION);
    }
    
    private static String getStringRepresentationOfCards(ArrayList<Card> cards) {
        String value = "";
        for(int i = 0; i < cards.size(); i++) {
            if(i != 0 && i != cards.size() - 1) {
                value += ",";
            }
            
            value += cards.get(i);
        }
        
        return value;
    }
}
