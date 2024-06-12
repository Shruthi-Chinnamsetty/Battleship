import java.util.ArrayList;

public class bonus {

    public static double[] QB_DamageReport(char[][] board){
    	
    	

        int[] destroyer = {0, 0};
        int[] cruiser = {0, 0};
        int[] battleship = {0, 0};
        int[] carrier = {0, 0};

        char[][] result = getShips(board);

        for(int i = 0; i< result.length; i++){

            if (checkChars(result[i], '.')){
                continue;
            }

            if (result[i].length == 2){
                destroyer[0] += 2;
                destroyer[1] += countStars(result[i]);
            }

            if (result[i].length == 3){
                cruiser[0] += 3;
                cruiser[1] += countStars(result[i]);
            }

            if (result[i].length == 4){
                battleship[0] += 4;
                battleship[1] += countStars(result[i]);
            }

            if (result[i].length == 5){
                carrier[0] += 5;
                carrier[1] += countStars(result[i]);
            }

        }

        double[] report = new double[4];

        double a = (carrier[0] == 0) ? -1 : ((carrier[1] == 0) ? 0 : ((double) carrier[1] * 100) / carrier[0]);

        double b = (battleship[0] == 0) ? -1 : ((battleship[1] == 0) ? 0 : ((double) battleship[1] * 100) / battleship[0]);

        double c = (cruiser[0] == 0) ? -1 : ((cruiser[1] == 0) ? 0 : ((double) cruiser[1] * 100) / cruiser[0]);

        double d = (destroyer[0] == 0) ? -1 : ((destroyer[1] == 0) ? 0 : ((double) destroyer[1] * 100) / destroyer[0]);
        
        

        return report;
        
    }

    public static int countStars(char[] array) {

        int count = 0;

        for (char c : array) {
            if (c == '*') {
                 count +=  1;
            }
        }

        return count;

    }

    public static boolean checkChars(char[] array, char targetChar1) {

        for (char c : array) {
            if (c == targetChar1) {
                return true; 
            }
        }

        return false;
    }

    public static char[][] getShips(char[][] board) {
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


    public static void main(String[] args)   {
        char[][] board = {
            {'*', '*', '*', '*', '.', '.', '*', '*', 'S', '*'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', 'S', 'S', '.', 'S', 'S', '.', 'S', '*'},
            {'.', '.', '.', 'S', 'S', '.', '.', '.', '.', '.'},
            {'.', '.', '*', 'S', 'S', 'S', '*', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'S', 'S', '*', '*', 'S', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '*', '*', '*', '*', '*', '.', '.'},
            {'*', '*', '*', '.', '.', '.', '.', '.', '.', '.'}
        };

        float[] report = countSunk(board);

        System.out.println(report);



    }
}