import java.util.HashMap;

public class task4 {
    public static int checkSquare(int r, char c, char[][] board){

        if (r < 1 || r>10){
            return 0;
        }

        if (!(c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G' || c == 'H' || c == 'I' || c == 'J')){
            return 1;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        map.put('I', 8);
        map.put('J', 9);

        char square = board[r-1][map.get(c)];

        if (square == 'S'){
            return 2;
        }

        if (square == '.'){
            return 3;
        }

        if (square == '*'){
            return 4;
        }

        return 5;
    }
    public static void main(String[] args){
        
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
    
        System.out.println(checkSquare(1, 'C', board));

    }
}
