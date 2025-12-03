import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends CasinoGames {

    private ArrayList<Integer> playerHand;
    private ArrayList<Integer> dealerHand;
    private Scanner input;

    // Constructor
    public BlackJack(double costToPlay) {
        super("BlackJack", 1, 52, costToPlay);
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // Deal a simple card from 1–11
    private int dealCard() {
        return (int)(Math.random() * 11) + 1;
    }

    // Add up hand
    private int handTotal(ArrayList<Integer> hand) {
        int total = 0;
        for (int card : hand) {
            total += card;
        }
        return total;
    }

    // Required override
    @Override
    public void playRound() {

        // Reset hands
        playerHand.clear();
        dealerHand.clear();

        System.out.println("\n--- Blackjack ---");

        // Initial cards
        playerHand.add(dealCard());
        playerHand.add(dealCard());
        dealerHand.add(dealCard());

        // Player turn
        boolean playing = true;
        while (playing) {
            System.out.println("Your hand: " + playerHand + " (Total: " + handTotal(playerHand) + ")");
            System.out.print("Hit (H) or Stand (S)? ");
            String choice = input.nextLine().toUpperCase();

            if (choice.equals("H")) {
                playerHand.add(dealCard());
                if (handTotal(playerHand) > 21) {
                    System.out.println("You busted!");
                    addLoss();
                    return;
                }
            } else {
                playing = false;
            }
        }

        // Dealer draws until at least 16
        while (handTotal(dealerHand) < 16) {
            dealerHand.add(dealCard());
        }

        System.out.println("Dealer hand: " + dealerHand + " (Total: " + handTotal(dealerHand) + ")");

        // Decide winner (super simple)
        int playerTotal = handTotal(playerHand);
        int dealerTotal = handTotal(dealerHand);

        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("You win!");
            addWin();
        } else if (playerTotal == dealerTotal) {
            System.out.println("Tie!");
        } else {
            System.out.println("Dealer wins!");
            addLoss();
        }
    }
}
