/*
Programmer: Simone Brown
Date: 12/5/2025 
Class: 2025FA.CSC.151.2802
Instructor: Mrs. Keller 
Purpose: Extends the CasinoGames class, and allows someone to play a simulated game of Bingo 
 */
import java.util.*; 
// This is the actual class which will implement Abstract methods like start or quit or wager.  
public class Bingo extends CasinoGames {
    public Bingo(String gameName, int numPlayers, int numCards, double costToPlay) {
        super(gameName, numPlayers, numCards, costToPlay);
        this.gameName = "Bingo";
        this.costToPlay = costToPlay; 
        this.numPlayers = 1;
        this.numCards = 0;  
    }
    // Child data members
    private double betAmount;
    private double totalWinnings;
    private double totalLosses;

    Scanner input = new Scanner(System.in); 
    public int[][] boardGenerate() {
        // this generates a new 5 x 5 board of numbers which corrspond to various columns
        int[][] testBoard = new int[5][5]; 
            for (int i = 0; i < testBoard.length; i++) {
                for (int j = 0; j < testBoard[i].length; j++) {
                    if (i == 0) {
                        int bColumn = (int) (Math.random() * 15) + 1;
                        testBoard[j][i] = bColumn; 

                    }
                    if (i == 1) {
                        int iColumn = (int) (Math.random() * (30 - 16 + 1)) + 16;
                        testBoard[j][i] = iColumn; 
                    }
                    if (i == 2) {
                        int nColumn = (int) (Math.random() * (45 - 31 + 1)) + 31;
                        testBoard[j][i] = nColumn; 
                    }
                    if (i == 3) {
                        int gColumn = (int) (Math.random() * (60 - 46 + 1)) + 46;
                        testBoard[j][i] = gColumn; 
                    }
                    if (i == 4) {
                        int oColumn = (int) ((Math.random() * (75 - 61 + 1)) + 61);
                        testBoard[j][i] = oColumn; 
                    }
                }
            }
        testBoard[2][2] = 0;  
        return testBoard; 
    }
    public int[][] findNum(int[][] board, int num) {
        // this finds the number and makes the adjustment to the board 
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == num) {
                        board[i][j] = 0; 
                    }
                }
            }
        return board; 
    }

    public static boolean checkWin(int[][] board) {
        // checks if there is a horizontal win 
        if(((board[0][0] == 0 && board[0][1] == 0 && board[0][2] == 0 && board[0][3] == 0 && board[0][4] == 0) || (board[1][0] == 0 && board[1][1] == 0 && (board[1][2] == 0 && board[1][3] == 0 && board[1][4] == 0) || (board[2][0] == 0 && board[2][1] == 0 && board[2][2] == 0 && board[2][3] == 0 && board[2][4] == 0) || (board[3][0] == 0 && board[3][1] == 0 && (board[3][2] == 0 && board[3][3] == 0 && board[3][4] == 0) || (board[4][0] == 0 && board[4][1] == 0 && (board[4][2] == 0 && board[4][3] == 0 && board[4][4] == 0)))))) {
            return true; 
        }
        // checks if there is a vertical win
        else if ((board[0][0] == 0 && board[1][0] == 0 && board[2][0] == 0 && board[3][0] == 0 && board[4][0] == 0) || (board[0][1] == 0 && board[1][1] == 0 && board[2][1] == 0 && board[3][1] == 0 && board[4][1] == 0) || (board[0][2] == 0 && board[1][2] == 0 && board[2][2] == 0 && board[3][2] == 0 && board[4][2] == 0) || (board[0][3] == 0 && board[1][3] == 0 && board[2][3] == 0 && board[3][3] == 0 && board[4][3] == 0) || (board[0][4] == 0 && board[1][4] == 0 && board[2][4] == 0 && board[3][4] == 0 && board[4][4] == 0)) {
            return true; 
        }
        // checks if there is a diagnonal win
        else if ((board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0 && board[4][4] == 0) || (board[4][0] == 0 && board[3][1] == 0 && board[2][2] == 0 && board[1][3] == 0 && board[0][4] == 0)) {
            return true; 
        } 
        return false; 
    }

    public void printBoard(int[][] board) {
        // prints the board to display results 
        System.out.println(""); 
        System.out.println(""); 
        System.out.printf("B\tI\tN\tG\tO"); 
        for (int i = 0; i < board.length; i++) {
            System.out.println(""); 
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(board[i][j] + " \t");  
        }
     
        
    }
    System.out.println("");
    }
    public void start() {
        // when a player starts, a bet will be placed, if the player board wins, then the player triples their gamble. otherwise, they lose it from their balance. 
        int[][] playerBoard = boardGenerate();
        int[][] oppBoardA = boardGenerate(); 
        int[][] oppBoardB = boardGenerate();

        System.out.println("Welcome to Bingo! Generating random boards: \n");

        System.out.println("YOUR BOARD:"); 
        printBoard(playerBoard);
        System.out.println("\nOPPOSING BOARD 1: "); 
        printBoard(oppBoardA);
        System.out.println("\nOPPOSING BOARD 2: "); 
        printBoard(oppBoardB);
        
        System.out.println("\nPress any key to continue: "); 
        
        while (!checkWin(playerBoard) && !checkWin(oppBoardA) && !checkWin(oppBoardB)) {
            int randomNumber = (int) (Math.random() * 75 + 1);

            printBoard(playerBoard);
            printBoard(oppBoardA); 
            printBoard(oppBoardB);

            findNum(playerBoard, randomNumber); 
            findNum(oppBoardA, randomNumber);
            findNum(oppBoardB, randomNumber);
        }

        System.out.println("FINAL BOARDS");

        System.out.println("\nPlayer Board");
        //System.out.println(checkWin(playerBoard));
        if (checkWin(playerBoard)) {
            System.out.println("Your board has won!");
            double winning = getCostToPlay() * 3; 
            System.out.println("You win: " + winning + " dollars!"); 
        }
        else {
            System.out.println("You've lost :(");
            System.out.println("Deducting " + getCostToPlay()); 
        }
        printBoard(playerBoard);
        if (checkWin(oppBoardA)) {
            System.out.println("\nOppBoardA board has won!"); 
        }
        else {
            System.out.println("This board lost"); 
        }
        printBoard(oppBoardA);
        System.out.println("\nOpposing Board 2"); 
        if (checkWin(oppBoardB)) {
            System.out.println("OppBoardB board has won!"); 
        }
        else {
            System.out.println("This board lost"); 
        }
        printBoard(oppBoardB);
    }

    public static void main(String[] args) {
        Scanner betInput = new Scanner(System.in); 
        double bet;
        System.out.println("How much do you want to bet on this game of Bingo? : "); 
        bet = betInput.nextDouble(); 
        Bingo bingo = new Bingo(null, 0, 0, bet); 
        bingo.playRound();  
    }
    @Override
    public void playRound() {
        // when a player starts, a bet will be placed, if the player board wins, then the player triples their gamble. otherwise, they lose it from their balance. 
        int[][] playerBoard = boardGenerate();
        int[][] oppBoardA = boardGenerate(); 
        int[][] oppBoardB = boardGenerate();

        System.out.println("Welcome to Bingo! Generating random boards: \n");

        System.out.println("YOUR BOARD:"); 
        printBoard(playerBoard);
        System.out.println("\nOPPOSING BOARD 1: "); 
        printBoard(oppBoardA);
        System.out.println("\nOPPOSING BOARD 2: "); 
        printBoard(oppBoardB);
        
        System.out.println("\nPlace your bet: "); 
        betAmount = costToPlay; 
        
        while (!checkWin(playerBoard) && !checkWin(oppBoardA) && !checkWin(oppBoardB)) {
            int randomNumber = (int) (Math.random() * 75 + 1);

            printBoard(playerBoard);
            printBoard(oppBoardA); 
            printBoard(oppBoardB);

            findNum(playerBoard, randomNumber); 
            findNum(oppBoardA, randomNumber);
            findNum(oppBoardB, randomNumber);
        }

        System.out.println("FINAL BOARDS");

        System.out.println("\nPlayer Board");
        //System.out.println(checkWin(playerBoard));
        if (checkWin(playerBoard)) {
            System.out.println("Your board has won!");
            double winning = betAmount * 3; 
            System.out.println("You win: " + winning + " dollars!");
            addWin();  
        }
        else {
            System.out.println("You've lost :(");
            System.out.println("Deducting " + betAmount + " dollars from your balance."); 
            addLoss();   
        }
        printBoard(playerBoard);
        if (checkWin(oppBoardA)) {
            System.out.println("\nOppBoardA board has won!"); 
        }
        else {
            System.out.println("This board lost"); 
        }
        printBoard(oppBoardA);
        System.out.println("\nOpposing Board 2"); 
        if (checkWin(oppBoardB)) {
            System.out.println("OppBoardB board has won!"); 
        }
        else {
            System.out.println("This board lost"); 
        }
        printBoard(oppBoardB);
    }
}
