import java.util.HashMap;

public class Hi{

    // Method to count ships based on parameters
    public static int countShips(char[][] board, String typeOfShip, String damageTypeOfShip) {

        HashMap<String, Integer> sizesOfShipTypes = new HashMap<>();

        sizesOfShipTypes.put("Carrier", 5);
        sizesOfShipTypes.put("Battleship", 4);
        sizesOfShipTypes.put("Cruiser", 3);
        sizesOfShipTypes.put("Destroyer", 2);

        boolean validTypeOfShip;
        if (typeOfShip!= "Carrier" && typeOfShip!= "Battleship" && typeOfShip!= "Cruiser" && typeOfShip!= "Destroyer"){
            validTypeOfShip = false;

        } else {
            validTypeOfShip = true;
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
        
        // Iterate through the board to count ships
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // If the current position is part of the ship
                if (board[row][col] == 'S' || board[row][col] == '*') {
                    // Check if this position belongs to the specified ship type
                    int shipLength = sizesOfShipTypes.get(typeOfShip);
                    boolean isPartOfShip = true;
                    for (int i = 1; i < shipLength; i++) {
                        if (col + i >= board[0].length || board[row][col + i] != 'S') {
                            isPartOfShip = false;
                            break;
                        }
                    }
                    if (isPartOfShip) {
                        // Check if this ship matches the specified damage type
                        switch (damageTypeOfShip) {
                            case "undamaged":
                                if (board[row][col] == 'S') {
                                    sunkShips++;
                                }
                                break;
                            case "damaged":
                                if (board[row][col] == '*') {
                                    sunkShips++;
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
                                    sunkShips++;
                                }
                                break;
                            case "all":
                                sunkShips++;
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
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', 'S', 'S', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'S', 'S', 'S', 'S', 'S', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'S', 'S', 'S', 'S', 'S', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        
        System.out.println("Number of undamaged carriers: " + countShips(board, "Carrier", "undamaged"));
    }
}
