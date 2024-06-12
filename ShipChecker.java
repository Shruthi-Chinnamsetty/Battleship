public class ShipChecker {
    public static int countSunkShips(char[][] board) {
        int sunkShips = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    boolean isSunk = true;

                    // Check horizontally for ship
                    for (int k = j; k < board[i].length; k++) {
                        if (board[i][k] == 'S') {
                            isSunk = false;
                            break;
                        } else if (board[i][k] == '.') {
                            break; // Reached end of ship
                        }
                    }

                    if (isSunk) {
                        sunkShips++;
                        // Skip remaining cells of the ship
                        while (j < board[i].length && board[i][j] == '*') {
                            j++;
                        }
                    }
                }
            }
        }

        return sunkShips;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '*', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '*', '*', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '*', '*', '*', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        int sunkShips = countSunkShips(board);
        System.out.println("Number of sunk ships: " + sunkShips); // Output: 1
    }
}
