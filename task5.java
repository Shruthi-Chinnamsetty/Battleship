import java.util.ArrayList;
import java.util.HashMap;

public class task5{

    public static boolean checkChars(char[] array, char targetChar1, char targetChar2) {
        boolean char1Exists = false;
        boolean char2Exists = false;

        for (char c : array) {
            if (c == targetChar1) {
                char1Exists = true; 
            }
            if (c == targetChar2) {
                char2Exists = true; 
            }

            if (char1Exists && char2Exists) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkDot(char[] array, char targetChar1) {

        for (char c : array) {
            if (c == targetChar1) {
                return true; 
            }
        }

        return false;
    }

    public static char[][] getCombinations(char[][] board) {
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

    public static int checkShips(char[][] board, char s, int shipsize){

        int shipCount = 0;

        for (int i = 0; i < board.length; i++) {
                    
            int j = 0;

            int k;                   

            while(j < 10){

                boolean isSunk = true;

                for (k = j; k < j+shipsize && k < 10; k++) {
            
                    if (board[i][k] != s) {
                        isSunk = false;
                        j += 1;
                        break;
                    }
                }

                if (isSunk) {
                    
                    if (k == 10){


                        boolean valid = true;

                        for (int z = 9; z > 9-shipsize; z--){
                            if (board[i][z] != s){
                                valid = false;
                            }
                        }

                        if(valid){
                            if (board[i][k-(shipsize+1)] == '.'){
                                shipCount += 1;
                                break;
                            }
                            break;
                        }

                    }

                    if (k < 9){

                        if (board[i][k] == '.'){

                            try{

                                if (board[i][k-(shipsize+1)] == '.'){

                                    shipCount += 1;
                                    j = k;

                                }
                            }
                            catch (Exception e){
                                shipCount += 1;
                                j = k;
                            }

                            j = k;

                        }

                        else{

                            int z;

                            for (z=k; z<10; z++){
                                if (board[i][z] != s){
                                    j = z;
                                    break;
                                }
                            }
                            
                            if(z == 10){
                                break;
                            }

                        }

                    }
                    
                    else{
                        break;
                    }
                }

            }           
        }

        return shipCount;

    }

    public static int countShips(char[][] board, String typeOfShip, String damageTypeOfShip) {

        HashMap<String, Integer> sizesOfShipTypes = new HashMap<>();

        sizesOfShipTypes.put("Carrier", 5);
        sizesOfShipTypes.put("Battleship", 4);
        sizesOfShipTypes.put("Cruiser", 3);
        sizesOfShipTypes.put("Destroyer", 2);

        if (typeOfShip!= "Carrier" && typeOfShip!= "Battleship" && typeOfShip!= "Cruiser" && typeOfShip!= "Destroyer"){
            return -1;
        }

        if(damageTypeOfShip!= "undamaged" && damageTypeOfShip!= "damaged" && damageTypeOfShip!= "sunk" && damageTypeOfShip!= "all types"){
            return -2;
        }

        int shipsize = sizesOfShipTypes.get(typeOfShip);

        int shipCount = 0;

        switch (damageTypeOfShip) {    
                
            case "sunk":
                
                shipCount = checkShips(board, '*', shipsize);     
                break;       

            case "undamaged":

                shipCount = checkShips(board, 'S', shipsize);
                break;

            case "damaged":

                char[][] result = getCombinations(board);

                for (int i = 0; i < result.length; i++){

                    boolean undamaged = checkChars(result[i], 'S', '*');

                    if (undamaged && result[i].length == shipsize){
                        shipCount += 1;
                    }

                }

                break;

            case "all types":
                
                char[][] result2 = getCombinations(board);

                for(int i = 0; i< result2.length; i++){

                    boolean dot = checkDot(result2[i], '.');

                    if(!dot && result2[i].length == shipsize){

                        shipCount += 1;
        
                    }

                }

        }
        
        return shipCount;
 
    }
    
    public static void main(String[] args) {
        char[][] board = {
            {'*','S','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','S','S','S','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','*','*','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'}
    };
        System.out.println("Number of Given type of ship: " + countShips(board, "Cruiser", "all types"));
    }
}