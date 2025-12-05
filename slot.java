/* 
Afton Pate 
12/5/25
This program simulates a  slot machine
*/


import java.util.*;
// My slot class, includes wins, losses, and bet and stuff 
public class slot {
    private int num1;
    private int num2;
    private int num3;
    private int bet;
    private static int count = 0;
    private static double balance = 0;
    static int wins; 
    static int losses; 

    public slot() {
        this.bet = 3;
    }

    public slot(int bet) {
        this.bet = bet;
    }
    // This is MY clear function. IT makes the code look better while running
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    

    // This part finds 3 random numbers and prints them out 
    public void play() {
        num1 = (int)(Math.random() * 10) + 1;
        num2 = (int)(Math.random() * 10) + 1;
        num3 = (int)(Math.random() * 10) + 1;
        count++;
        System.out.println(num1 + " " + num2 + " " + num3);
    }

    // This code finds how many numbers are the same and gives back the bet accordingly 
    public int outcome() {
        if (num1 == num2 && num2 == num3) {
            balance += bet * 5;
            wins++;
            return 1;
        } else if (num1 == num2 || num1 == num3 || num2 == num3) {
            balance += bet * 2;
            wins++;
            return 2;
        } else {
            balance -= bet;
            losses++; 
            return 0;
        }
    }

    public static int getCount() {
        return count;
    }
    // Runner / tester / Main 
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the starting balance: ");
        slot.balance = kb.nextDouble();

        String replay;
        do {
            clear();
            System.out.println("Enter your bet amount: ");
            int bet = kb.nextInt();
            clear();
            System.out.println("Enter your # of plays: ");
            int numturns = kb.nextInt();
            clear();

           for (int i = 1; i <= numturns; i++) {
    slot s1 = new slot(bet);

    s1.play();
    System.out.println("Turn # " + slot.getCount());

    System.out.println("Your outcome was: " + s1.outcome());
    System.out.printf("Balance: $%.2f\n", slot.balance);

}


            System.out.println("Do you want to play again? (y/n): ");
            replay = kb.next().toLowerCase();

        } while (replay.equals("y"));
        clear();
        System.out.printf("Cashed out at: $%.2f\n", slot.balance);
        System.out.printf("You won %d times\n", slot.wins);
        System.out.printf("You losses %d times\n", slot.losses);
    }
}
