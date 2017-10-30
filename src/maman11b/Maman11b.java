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
        
        int replay;
        do {
            user.clean();
            pc.clean();
            dealUser(deck, user);
            dealPc(deck, pc);
            String message = "Your cards are: " + 
                    getStringRepresentationOfCards(user.getCards()) + 
                    " and they total " + user.getHandValue() + " points.\n" + 
                    "The AI's cards are: " + 
                    getStringRepresentationOfCards(pc.getCards()) + 
                    " and they total " + pc.getHandValue() + " points.\n" + 
                    getWinningMessage(user.getHandValue(), pc.getHandValue()) +
                    "\nWould you like to start another match?";
                    
            replay = JOptionPane.showConfirmDialog(null, message, 
                    "End of match!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
        } while(replay == JOptionPane.YES_OPTION);
    }
    
    private static void dealUser(Deck deck, Gambler user) {
        user.addCard(deck.getNextCard());
        user.addCard(deck.getNextCard());
        int reply = JOptionPane.YES_OPTION;
        while(reply == JOptionPane.YES_OPTION && user.getHandValue() < 21) {
            // Build message
            String message = "Your cards are: " + 
                    getStringRepresentationOfCards(user.getCards()) +
                    ". \nWould you like to draw?";
            
            //Ask user
            reply = JOptionPane.showConfirmDialog(null, message, "21", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(reply == JOptionPane.YES_OPTION) {
                user.addCard(deck.getNextCard());
            }
        }
        
        if(user.getHandValue() >= 21) {
            JOptionPane.showMessageDialog(null, "Your cards are: " + 
                    getStringRepresentationOfCards(user.getCards()) +
                    ".\nYou cannot draw more cards.");
        }
    }
    
    private static void dealPc(Deck deck, Gambler pc) {
        pc.addCard(deck.getNextCard());
        pc.addCard(deck.getNextCard());
        while(pc.getHandValue() < 18) {
            pc.addCard(deck.getNextCard());
        }
    }
    
    private static String getWinningMessage(int userValue, int pcValue) {
        if(userValue > 21) {
            userValue = -1;
        }
        if(pcValue > 21) {
            pcValue = -1;
        }
        
        String message;
        if(userValue > pcValue) {
            message = "You won!";
        }
        else if(pcValue > userValue) {
            message = "You lost!";
        }
        else if(pcValue == userValue && pcValue > 0) {
            message = "It's a tie!";
        }
        else {
            message = "You both lost!";
        }
        
        return message;
    }
    
    private static String getStringRepresentationOfCards(ArrayList<Card> cards) {
        String value = "(";
        for(int i = 0; i < cards.size(); i++) {
            value += cards.get(i);
            if(i != cards.size() - 1) {
                value += ", ";
            }
        }
        
        return value + ")";
    }
}
