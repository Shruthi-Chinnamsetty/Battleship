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
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'S' || board[i][j] == '*') {
                    int shipLength = sizesOfShipTypes.get(typeOfShip);
                    boolean isPartOfShip = true;
                    for (int k = 1; k < shipLength; k++) {
                        if (j + k >= board[0].length || board[i][j + k] != 'S') {
                            isPartOfShip = false;
                            break;
                        }
                    }
                    if (isPartOfShip) {
                        switch (damageTypeOfShip) {
                            case "undamaged":
                                if (board[i][j] == 'S') {
                                    sunkShips += 1;
                                }
                                break;
                            case "damaged":
                                if (board[i][j] == '*') {
                                    sunkShips += 1;
                                }
                                break;
                            case "sunk":
                                boolean isSunk = true;
                                for (int k = 0; k < shipLength; k++) {
                                    if (board[i][j + k] != '*') {
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
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', 'S', 'S', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'S', 'S', 'S', 'S', '*', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'S', 'S', 'S', 'S', 'S', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        
        System.out.println("Number of undamaged carriers: " + countShips(board, "Carrier", "undamaged"));
    }
}
