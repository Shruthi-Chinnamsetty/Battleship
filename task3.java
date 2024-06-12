import java.util.ArrayList;

public class task3 {

    // main method for counting sunk ships
    public static int countSunk(char[][] board){  	
    	
    	char boardSquare = ' ';
		char boardSquare1 = ' ';
		
    	
        int countOfShips = 0;

        char[][] result = getShips(board);

        
        
        
        char[][] noShipsBoard = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            };
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardSquare = board[i][j];
                
                        
                    }
        }
        
        for (int c = 0; c < noShipsBoard.length; c++) {
            for (int d = 0; d < noShipsBoard[c].length; d++) {
                boardSquare1 = board[c][d];
                    
                
                }
            }
        
		if (boardSquare == '.' && boardSquare1 == '.') {
        	return -1;
        }else {
        	for (int i = 0; i < result.length; i++){

                if (!checkChars(result[i], '.') && !checkChars(result[i], 'S')){
                    countOfShips += 1;
                }

            }
        	return countOfShips;
        	
        }
        
    }

    public static boolean checkChars(char[] array, char targetChar1) {

        for (char c : array) {
            if (c == targetChar1) {
                return true; 
            }
        }

        return false;
    }

    public static char[][] getShips(char[][] board) {
        ArrayList<String> combinations = new ArrayList<>();
        
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                if (c != '.') {
                    sb.append(c);
                } else if (sb.length() > 0) {
                    combinations.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 0) {
                combinations.add(sb.toString());
            }
        }

        char[][] result = new char[combinations.size()][];
        for (int i = 0; i < combinations.size(); i++) {
            result[i] = combinations.get(i).toCharArray();
        }
        
        return result;
    }


    public static void main(String[] args)   {
        char[][] board = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', 'S', 'S', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
        };
        System.out.println(countSunk(board));

    }
}