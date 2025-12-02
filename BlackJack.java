public class BlackJack {
    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!");

        // Example of dealing two cards to a player
        int playerCard1 = dealCard();
        int playerCard2 = dealCard();
        int playerTotal = calculateHandValue(playerCard1, playerCard2);

        System.out.println("Player's cards: " + playerCard1 + " and " + playerCard2);
        System.out.println("Player's total hand value: " + playerTotal);

        // Example of dealing two cards to the dealer
        int dealerCard1 = dealCard();
        int dealerCard2 = dealCard();
        int dealerTotal = calculateHandValue(dealerCard1, dealerCard2);

        System.out.println("Dealer's cards: " + dealerCard1 + " and " + dealerCard2);
        System.out.println("Dealer's total hand value: " + dealerTotal);
    }

    // Method to simulate dealing a card (values between 1 and 11)
    public static int dealCard() {
        return (int) (Math.random() * 11) + 1;
    }

    // Method to calculate the total value of a hand
    public static int calculateHandValue(int card1, int card2) {
        return card1 + card2;
    }
}
