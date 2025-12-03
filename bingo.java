public class bingo {
    // four different bingo boards
    public static void main(String[] args) {

    String bingo = "BINGO";

    int b = (int) (Math.random() * 15) + 1; 
    
    System.out.println(b); 
        

    int[][] player = {{1, 2 , 3,  4, 5}, {6, 7, 8, 9, 10} , {11, 12, 13, 14, 15} , {16, 17, 18, 19, 20} , {21, 22, 23, 24, 25}}; 
    int[][] boardA = {new int[5] , new int[5], new int[5], new int[5], new int[5]}; 
    int[][] boardB = {}; 
    int[][] boardC = {};

    int[][] testBoard = {{1, 2 , 3,  4, 5}, {6, 7, 8, 9, 10} , {11, 12, 13, 14, 15} , {16, 17, 18, 19, 20} , {21, 22, 23, 24, 25}};

    testBoard[2][2] = 0; 

    // printing segments 
    for (int i = 0; i < testBoard.length; i++) {
        System.out.println(""); 
        for (int j = 0; j < testBoard[i].length; j++) {
            System.out.printf(testBoard[i][j] + " \t");  
        }
        //System.out.printf("\t"); 
        //for (int j = 0; j < boardA[i].length; j++) {
            //System.out.printf(boardA[i][j] + " \t");  
        //}
    }

    // everyone starts with a guarenteed 0 at 2 2. this is considered the free space. the object is to get 5 numbers in a row.
    // board must be filled with random numbers -  B (1 - 15) I (16 - 30) N (31 - 45) G (46 - 60) O (61 - 75)

    
    for (int i = 0; i < testBoard.length; i++) {
        for (int j = 0; j < testBoard[i].length; j++) {
            if (i == 0) {

            }
            if (i == 1) {

            }
            if (i == 2) {

            }
            if (i == 3) {

            }
            if (i == 4) {

            }
        }
    }

    for (int i = 0; i < testBoard.length; i++) {
        System.out.println(""); 
        for (int j = 0; j < testBoard[i].length; j++) {
            System.out.printf(testBoard[i][j] + " \t");  
        }
    }
    }
}
