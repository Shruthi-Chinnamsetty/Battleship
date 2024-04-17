public class task2 {
    public static int checkValid(char[][] board){

        if (board == null){
            return 0;
        }

        if (board.length != 10){
            return 1;
        }

        for(int i=0;i<10;i++){
            if(board[i].length != 10){
                return 1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char boardSquare = board[i][j];
                if (boardSquare != '*' && boardSquare != 'S' && boardSquare != '.') {
                    return 2;
                }
            }
        }

        return 3;
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
    

        System.out.println(checkValid(board));

    }
}
