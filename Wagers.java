/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.blackjack;

/**
 *
 * @author Manee
 */
public class Wagers {
    private int wager;
    private int balance;
    
    public Wagers() {
        this.wager = 0;
        this.balance = 1000;
    }
    
    public void setWager(int wager) {
        if (wager <= 0 && wager > balance) {
            throw new IllegalArgumentException("Wager cannot be negative");
        }
        this.wager = wager;
        this.balance -= this.wager;
    }
    
    public int getWager() {
        return this.wager;
    }
        
    public String Push() {
        this.balance += this.wager;
        return "Push!";
    }
    
    public String Win() {
        this.balance += this.wager * 2;
        return "You have won: $" + this.wager * 2;
    }
    
    public String Loss() {
        return "Wager subtracted from your balance!";
    }
}
