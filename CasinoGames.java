/* 
Abstract parent class for various casino games
*/

public abstract class CasinoGames {

    // Parent data members
    protected String gameName;
    protected int numPlayers;
    protected int numCards;
    protected double costToPlay;
    protected int numWins;
    protected int numLosses;

    // Constructor
    public CasinoGames(String gameName, int numPlayers, int numCards, double costToPlay) {
        this.gameName = gameName;
        this.numPlayers = numPlayers;
        this.costToPlay = costToPlay;
        this.numWins = 0;
        this.numLosses = 0;
    }

    // Accessors / Mutators
    public String getGameName() { return gameName; }
    public int getNumPlayers() { return numPlayers; }
    public double getCostToPlay() { return costToPlay; }
    public int getNumWins() { return numWins; }
    public int getNumLosses() { return numLosses; }

    public void setNumPlayers(int n) { numPlayers = n; }

    public void addWin() { numWins++; }
    public void addLoss() { numLosses++; }

    // Common parent method (can be overridden)
    public double calculateProfit() {
        return (numWins * costToPlay) - (numLosses * costToPlay);
    }

    // Abstract method → all child classes must implement gameplay
    public abstract void playRound();
}
