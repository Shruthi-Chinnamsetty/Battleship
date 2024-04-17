public class battleship {
    public static boolean validBoardSquare(char[][] board) {
        boolean valid = true;
        if (board == null || board.length == 0) {
            valid = false;
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char boardSquare = board[i][j];
                    if (boardSquare != '*' && boardSquare != 'S' && boardSquare != '.') {
                        valid = false;
                        break;
                    }
                }
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'S', 'S', '.', '.', '.', '.', '.'}
        };

        System.out.println(validBoardSquare(board)); 
    }
}