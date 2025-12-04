// This is the actual class which will implement Abstract methods like start or quit or wager.  
public class BingoBoop {
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
    public int[][] findNum(int[][] board) {
        int randomNumber = (int) (Math.random() * 75 + 1);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == randomNumber) {
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
        System.out.println(""); 
        System.out.println(""); 
        System.out.printf("B\tI\tN\tG\tO"); 
        for (int i = 0; i < board.length; i++) {
            System.out.println(""); 
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(board[i][j] + " \t");  
        }
        
    }

    }
    public void start() {
        int[][] playerBoard = boardGenerate();
        int[][] oppBoardA = boardGenerate(); 
        int[][] oppBoardB = boardGenerate();

        printBoard(playerBoard);
        printBoard(oppBoardA);
        printBoard(oppBoardB);
        
        findNum(playerBoard); 
        printBoard(playerBoard);
    }

    public static void main(String[] args) {
        BingoBoop bingoBoop = new BingoBoop();
        int[][] test = new int[5][5]; 
        int[][] beep1 = {{1, 1, 1, 1, 1} , {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int[][] beep2 = {{0, 1, 1, 1, 1} , {0, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {0, 1, 1, 1, 1}};  
        bingoBoop.start();
        System.out.println(checkWin(beep1));
        System.out.println(checkWin(beep2)); 
    }
}
