public class task3 {
    public static int countSunk(char[][] board){
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char boardSquare = board[i][j];
                if (boardSquare == '*') {
                    count += 1;
                }
            }
        }

        return count;
    }
    public static void main(String[] args)   {
        char[][] board = {
            {'*', '*', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '*', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '*', '*', '*', '*', 'S', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'*', '*', '.', 'S', 'S', 'S', '*', '.', '.', '.'}
        };

        System.out.println(countSunk(board));

    }
}
