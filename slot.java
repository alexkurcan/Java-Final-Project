/* 
Afton Pate 
12/5/25
This program simulates a  slot machine
*/

import java.util.*;

public class Slot extends CasinoGames {

    private int num1;
    private int num2;
    private int num3;
    private int bet;
    private double balance;

    public Slot(double costToPlay, double startingBalance) {
        super("Slot Machine", 1, 0, costToPlay);
        this.bet = (int) costToPlay;
        this.balance = startingBalance;
    }

    public Slot(double costToPlay) {
        super("Slot Machine", 1, 0, costToPlay);
        this.bet = (int) costToPlay;
        this.balance = 100;
    }
    // This is MY clear function QUINT 
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    

    // Finds 3 random numbers 
    public void play() {
        num1 = (int)(Math.random() * 10) + 1;
        num2 = (int)(Math.random() * 10) + 1;
        num3 = (int)(Math.random() * 10) + 1;
        System.out.println(num1 + " " + num2 + " " + num3);
    }

    // To find how many numbers are the same and accoridngly update the bet 
    public int outcome() {
        if (num1 == num2 && num2 == num3) {
            balance += bet * 5;
            return 1;
        } else if (num1 == num2 || num1 == num3 || num2 == num3) {
            balance += bet * 2;
            return 2;
        } else {
            balance -= bet;
            return 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void playRound() {
        Scanner kb = new Scanner(System.in);

        clear();
        System.out.printf("Balance: $%.2f\n", balance);

        boolean validBet = false;
        while (!validBet) {
            System.out.println("Enter your bet amount: ");

            if (kb.hasNextInt()) {
                int b = kb.nextInt();
                if (b > 0 && b <= balance) {
                    bet = b;
                    validBet = true;
                } else {
                    System.out.println("Invalid bet amount.");
                }
            } else {
                System.out.println("Invalid input.");
                kb.next();
            }
        }

        clear();

        boolean validTurns = false;
        int numturns = 0;

        while (!validTurns) {
            System.out.println("Enter your # of plays: ");

            if (kb.hasNextInt()) {
                int t = kb.nextInt();
                if (t > 0) {
                    numturns = t;
                    validTurns = true;
                    // error handling 
                } else {
                    System.out.println("Invalid number.");
                }
            } else {
                System.out.println("Invalid input.");
                kb.next();
            }
        }

        clear();

        // so you dont go into the negitives 
        for (int i = 1; i <= numturns; i++) {

            if (balance < bet) {
                System.out.println("Not enough balance to continue.");
                break;
            }

            play();
            System.out.println("Turn # " + i);

            int result = outcome();

            // This adds wins or losses depending on if you win or loose
            if (result == 1) {
                System.out.println("Your outcome was: " + result);
                addWin();
            } else if (result == 2) {
                System.out.println("Your outcome was: " + result);
                addWin();
            } else {
                System.out.println("Your outcome was: " + result);
                addLoss();
            }

            System.out.printf("Balance: $%.2f\n", balance);
        }
    }
}

