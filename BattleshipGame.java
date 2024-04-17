public class BattleshipGame {

    public static int countShips(char[][] board, String typeOfShip, String damageTypeOfShip) {
        String[] shipTypes = {"Carrier", "Battleship", "Cruiser", "Destroyer"};
        int[] sizesOfShipTypes = {5, 4, 3, 2};
        
        int shipID = -1;
        boolean validTypeOfShip = false;
        for (int i = 0; i < shipTypes.length; i++) {
            if (shipTypes[i] == typeOfShip) {
                shipID = i + 1;
                validTypeOfShip = true;
            }
        }
        if (validTypeOfShip == false) {
            return -1;
        }

        boolean validDamageTypeOfShip;

        if(damageTypeOfShip!= "undamaged" && damageTypeOfShip!= "damaged" && damageTypeOfShip!= "sunk" && damageTypeOfShip!= "all types"){
            validDamageTypeOfShip = false;
        } 
        else {
            validDamageTypeOfShip = true;
        }


        if (validDamageTypeOfShip == false) {
            return -2;
        }
        
        int sunkShips = 0;
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // If the current position is part of the ship
                if (board[row][col] == 'S' || board[row][col] == '*') {
                    // Check if this position belongs to the specified ship type
                    int shipLength = sizesOfShipTypes[shipID - 1];
                    boolean isPartOfShip = true;
                    for (int i = 1; i < shipLength; i++) {
                        if (col + i >= board[0].length || board[row][col + i] != 'S') {
                            isPartOfShip = false;
                            break;
                        }
                    }
                    if (isPartOfShip) {
                        // Check if this ship matches the specified damage type
                        switch (typeOfShip) {
                            case "undamaged":
                                if (board[row][col] == 'S') {
                                    sunkShips += 1;
                                }
                                break;
                            case "damaged":
                                if (board[row][col] == '*') {
                                    sunkShips += 1;
                                }
                                break;
                            case "sunk":
                                boolean isSunk = true;
                                for (int i = 0; i < shipLength; i++) {
                                    if (board[row][col + i] != '*') {
                                        isSunk = false;
                                        break;
                                    }
                                }
                                if (isSunk) {
                                    sunkShips += 1;
                                }
                                break;
                            case "all":
                                sunkShips += 1;
                                break;
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
            {'.', '.', '.', '.', 'S', 'S', 'S', 'S', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', 'S', 'S', 'S', 'S', 'S', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', 'S', 'S', 'S', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        
    
        int numberOfShips = countShips(board, "Carrier", "undamaged");
        System.out.println("Number of undamaged carriers: " + numberOfShips);
    }
}
