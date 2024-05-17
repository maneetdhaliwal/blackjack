/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tutorial.blackjack;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Manee
 */
public class BlackJack {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int n = rand.nextInt(1, 12);
        int m = rand.nextInt(1, 12);
        int opp1 = rand.nextInt(1, 12);
        int opp2 = rand.nextInt(1, 12);
        String nOutput = (n == 11) ? "Ace" : String.valueOf(n);
        String mOutput = (m == 11) ? "Ace" : String.valueOf(m);
        String opp1Output = (opp1 == 11) ? "Ace" : String.valueOf(opp1);
        String opp2Output = (opp2 == 11) ? "Ace" : String.valueOf(opp2);
        System.out.println("Please enter a 3 digit bet");
        int bet = scan.nextInt();
        System.out.println("Your hand has a: " + nOutput + " and a " + mOutput);
        System.out.println("Opp has a: " + opp1Output + " and a SECRET CARD");
        
        int sum = n + m;
        if ( sum == 22) {
            sum = 2;
        }
        
        
        ArrayList<String> oppHand = new ArrayList<>();
        oppHand.add(opp1Output);
        oppHand.add(opp2Output);
        boolean turnOff = false;
        while (turnOff = false) {
            System.out.println("Press 1 to Hit, 2 to Stand, or 3 to Double");
            int input = scan.nextInt();
            if ((input != 1) && (input != 2) && (input != 3)) {
                System.out.println("Please enter a valid entry.");
                input = scan.nextInt();
            }
            
            if (input == 1) {
                int x = rand.nextInt(1, 12);
                String xOutput = (x == 11) ? "Ace" : String.valueOf(x);
                System.out.println("Your hand now has a " + mOutput + " and a " + nOutput + " and a " + xOutput);
                sum = m + n + x;
                if (sum > 21) {
                    System.out.println("you are out!");
                }
                System.out.println("Your opp has a " + opp1Output + " and a " + opp2Output);
                int sum2 = opp1 + opp2;
                
                while (sum2 < 22) {
                    int z = rand.nextInt(1, 12);
                    String zOutput = (z == 11) ? "Ace" : String.valueOf(z);
                    sum2 += z;
                    oppHand.add(zOutput);
                    System.out.println("Your opp has decided to Hit. They now have: " + String.join(", ", oppHand));
                    if (sum2 == sum) {
                        System.out.println("Push!");
                        break;
                    }
                                       
                    else if (sum2 > sum && sum2 < 22) {
                        System.out.println("Opp has won!");
                        break;
                    }
                  
                }
                
                
                if (sum2 > 22) {
                    System.out.println("You have won! Your earnings are: " + bet * 2);
                    turnOff = true;
                    break;
                } 
               
            }
            
            if (input == 2) {
                System.out.println("Your opp had a " + opp1Output + " and a " + opp2Output);
            }
            
            if (input == 3) {
                bet = bet*2;
                System.out.println("Stakes has been doubled!");
                int x = rand.nextInt(1, 12);
                String xOutput = (x == 11) ? "Ace" : String.valueOf(x);
                System.out.println("Your hand now has a " + mOutput + " and a " + nOutput + " and a " + xOutput);
                
            }
        }
    }
}
