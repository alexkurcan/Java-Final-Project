import java.util.Random;


public class Roulette extends CasinoGames {
    
    // Child data members
    private int winningNumber;
    private String betType;
    private double betAmount;
    private double totalWinnings;
    private double totalLosses;
    
    // Constructor
    public Roulette(int numPlayers, double costToPlay) {
        super("Roulette", numPlayers, 0, costToPlay);
        this.winningNumber = 0;
        this.betType = "";
        this.betAmount = 0.0;
        this.totalWinnings = 0.0;
        this.totalLosses = 0.0;
    }
    
    // Getters
    public int getWinningNumber() {
        return winningNumber;
    }
    
    public String getBetType() {
        return betType;
    }
    
    public double getBetAmount() {
        return betAmount;
    }
    
    public double getTotalWinnings() {
        return totalWinnings;
    }
    
    public double getTotalLosses() {
        return totalLosses;
    }
    
    // Setters
    public void setBetType(String type) {
        this.betType = type;
    }
    
    public void setBetAmount(double amount) {
        this.betAmount = amount;
    }
    
    // Spin the wheel 
    public void spinWheel() {
        Random rand = new Random();
        winningNumber = rand.nextInt(38); 
    }
    
    // Check if number is red
    public boolean isRed(int num) {
        if (num == 1 || num == 3 || num == 5 || num == 7 || num == 9 || 
            num == 12 || num == 14 || num == 16 || num == 18 || num == 19 || 
            num == 21 || num == 23 || num == 25 || num == 27 || num == 30 || 
            num == 32 || num == 34 || num == 36) {
            return true;
        }
        return false;
    }
    
    // Check if bet won
    public boolean checkWin() {
        if (betType.equals("red")) {
            return isRed(winningNumber);
        } else if (betType.equals("black")) {
            return !isRed(winningNumber) && winningNumber != 0 && winningNumber != 37;
        } else if (betType.equals("odd")) {
            return winningNumber % 2 == 1;
        } else if (betType.equals("even")) {
            return winningNumber % 2 == 0 && winningNumber != 0 && winningNumber != 37;
        }
        return false;
    }
    
    // Calculate payout
    public double calculatePayout() {
        if (checkWin()) {
            return betAmount * 2; 
        }
        return 0.0;
    }
    
    // Override parent method
    @Override
    public double calculateProfit() {
        return totalWinnings - totalLosses;
    }
    
    // Calculate win percentage
    public double getWinPercentage() {
        int totalGames = numWins + numLosses;
        if (totalGames == 0) {
            return 0.0;
        }
        return (numWins * 100.0) / totalGames;
    }
    
    // Play one round
    @Override
    public void playRound() {
        spinWheel();
        
        System.out.println("Spinning the wheel...");
        
        if (winningNumber == 37) {
            System.out.println("Winning number: green 00");
        } else if (winningNumber == 0) {
            System.out.println("Winning number: green 0");
        } else {
            String color = isRed(winningNumber) ? "red" : "black";
            String oddEven = (winningNumber % 2 == 1) ? "odd" : "even";
            System.out.println("Winning number: " + winningNumber + " (" + color + ", " + oddEven + ")");
        }
        
        boolean won = checkWin();
        
        if (won) {
            double payout = calculatePayout();
            System.out.println("You win! You get $" + payout);
            addWin();
            totalWinnings = totalWinnings + payout;
        } else {
            System.out.println("You lose! You lost $" + betAmount);
            addLoss();
            totalLosses = totalLosses + betAmount;
        }
        
        System.out.println("Total wins: " + numWins);
        System.out.println("Total losses: " + numLosses);
        System.out.println("Profit/Loss: $" + calculateProfit());
    }
    
    // Display game statistics
    public void displayStats() {
        System.out.println("Roulette Statistics");
        System.out.println("Game: " + gameName);
        System.out.println("Number of Players: " + numPlayers);
        System.out.println("Cost to Play: $" + costToPlay);
        System.out.println("Total Wins: " + numWins);
        System.out.println("Total Losses: " + numLosses);
        System.out.println("Win Percentage: " + getWinPercentage() + "%");
        System.out.println("Total Winnings: $" + totalWinnings);
        System.out.println("Total Losses: $" + totalLosses);
        System.out.println("Net Profit/Loss: $" + calculateProfit());
    }
}
