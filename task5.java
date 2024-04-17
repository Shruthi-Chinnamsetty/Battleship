public class task5 {
    public static int countShips(char[][] board, String shipType, String damageType) {
        if (shipType!= "Carrier" && shipType!= "Battleship" && shipType!= "Cruiser" && shipType!= "Destroyer") {
            return 0; //invalid ship type
        } else if (damageType!= "undamaged" && damageType!= "damaged" && damageType!= "sunk" && damageType!= "all types") {
            return 2; //invalid damage type
        }
        return 0;
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
                {'.', '.', '.', 'S', 'S', '.', '.', '.', '.', '.'}
            };

            System.out.println(countShips(board, "Carrier", "sunk"));

        }

    }