public class task2 {
    public static int checkValid(char[][] board){

        if (board == null){
            return 0; // null board
        }

        if (board.length != 10){
            return 1; // // board is wrong size
        }

        for(int i=0;i<10;i++){
            if(board[i].length != 10){
                return 1; // board is wrong size
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char boardSquare = board[i][j];
                if (boardSquare != '*' && boardSquare != 'S' && boardSquare != '.') {
                    return 2; // at least 1 invalid square
                }
            }
        }

        return 3; // board is valid
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
            {'.', '.', '.', 'S', 'S', '.', '.', '9', '.', '.'}
        };
    

        System.out.println(checkValid(board));

    }
}
