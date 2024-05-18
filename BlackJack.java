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
 * 
 * */
public class BlackJack {

    public void starter() {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Wagers wager = new Wagers();
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
        wager.setWager(bet);
        System.out.println("Your hand has a: " + nOutput + " and a " + mOutput);
        System.out.println("Opp has a: " + opp1Output + " and a SECRET CARD");
        
        int sum = n + m;
        // in the case of something like A, 5, 5 it should be a black jack and should not allow further options
        // allow blackjack
        int sum2 = opp1 + opp2;
        
        ArrayList<String> oppHand = new ArrayList<>();
        oppHand.add(opp1Output);
        oppHand.add(opp2Output);
        ArrayList<String> selfHand = new ArrayList<>();
        selfHand.add(nOutput);
        selfHand.add(mOutput);
        boolean turnOff = false;
        while (!turnOff) {
            System.out.println("Press 1 to Hit, 2 to Stand, or 3 to Double");
            int input = scan.nextInt();
            if ((input != 1) && (input != 2) && (input != 3)) {
                System.out.println("Please enter a valid entry.");
                continue;
            }
            
            if (input == 1) {
                int x = rand.nextInt(1, 12);
                String xOutput = (x == 11) ? "Ace" : String.valueOf(x);
                selfHand.add(xOutput);
                sum += x;
                System.out.println("You now have a: " + String.join(", ", selfHand));
                if (sum > 21) {
                    System.out.println("you are out!");
                    System.out.println("Your opp had a " + opp1Output + " and a " + opp2Output);
                    wager.Loss();
                    turnOff = true;
                }
                               
            }
            
            if (input == 2) {
                System.out.println("Your opp had a " + opp1Output + " and a " + opp2Output);
                if (sum2 > sum && sum2 < 22) {
                        System.out.println("Opp has won!"); 
                        wager.Win();
                        turnOff = true;
                    }
                boolean winner = false;
                while (!winner) {
                    int z = rand.nextInt(1, 12);
                    String zOutput = (z == 11) ? "Ace" : String.valueOf(z);
                    sum2 += z;
                    oppHand.add(zOutput);
                    System.out.println("Your opp has decided to Hit. They now have: " + String.join(", ", oppHand));
                    if (sum2 == sum) {
                        System.out.println("Push!");
                        wager.Push();
                        winner = true;
                        break;
                    }
                    else if (sum2 > 21) {
                        System.out.println("You have won! Your earnings are: " + bet * 2);
                        wager.Win();
                        winner = true;
                        break; 
                    }
                    else if (sum2 > sum && sum2 < 22) {
                        System.out.println("Opp has won!");
                        wager.Loss();
                        break;
                    }
                    else continue;
                }
                turnOff = true;
            }
            
            if (input == 3) {
                // fix this
                bet = bet*2;
                System.out.println("Stakes has been doubled!");
                int x = rand.nextInt(1, 12);
                String xOutput = (x == 11) ? "Ace" : String.valueOf(x);
                System.out.println("Your hand now has a " + mOutput + " and a " + nOutput + " and a " + xOutput);
                System.out.println("Your opp had a " + opp1Output + " and a " + opp2Output);

                if (sum2 == sum) {
                    System.out.println("Push!");
                    wager.Push();
                    break;
                }

                boolean winner = false;
                while (winner) {
                    int z = rand.nextInt(1, 12);
                    String zOutput = (z == 11) ? "Ace" : String.valueOf(z);
                    sum2 += z;
                    oppHand.add(zOutput);
                    System.out.println("Your opp has decided to Hit. They now have: " + String.join(", ", oppHand));
                    if (sum2 == sum) {
                        System.out.println("Push!");
                        wager.Push();
                        winner = true;
                        break;
                    }
                    else if (sum2 > 21) {
                        System.out.println("You have won! Your earnings are: " + bet * 2);
                        wager.Win();
                        winner = true;
                        break; 
                    }
                    else if (sum2 > sum && sum2 < 22) {
                        System.out.println("Opp has won!");
                        wager.Loss();
                        break;
                    }
                    else continue;
                }
                turnOff = true;
            }
        }
        scan.close();
    }
}

            }
        }
        scan.close();
    }
}
