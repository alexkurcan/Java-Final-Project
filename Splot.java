import java.util.*;
public class Splot {
    private int num1;
    private int num2;
    private int num3;
    private int bet;
    private static int count = 0;
    private static double balance = 0;
    static int wins; 

    public Splot() {
        this.bet = 3;
    }

    public Splot(int bet) {
        this.bet = bet;
    }
    
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    

    public void play() {
        num1 = (int)(Math.random() * 10) + 1;
        num2 = (int)(Math.random() * 10) + 1;
        num3 = (int)(Math.random() * 10) + 1;
        count++;
        System.out.println(num1 + " " + num2 + " " + num3);
    }

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
            return 0;
        }
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the starting balance: ");
        Splot.balance = kb.nextDouble();

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
    Splot s1 = new Splot(bet);

    s1.play();
    System.out.println("Turn # " + Splot.getCount());

    System.out.println("Your outcome was: " + s1.outcome());
    System.out.printf("Balance: $%.2f\n", Splot.balance);
    System.out.printf("You won %d times\n", Splot.wins);
}


            System.out.println("Do you want to play again? (y/n): ");
            replay = kb.next().toLowerCase();

        } while (replay.equals("y"));
        clear();
        System.out.printf("Cashed out at: $%.2f\n", Splot.balance);
    }
}