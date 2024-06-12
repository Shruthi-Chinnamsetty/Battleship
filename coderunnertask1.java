public class coderunnertask1 {
    public static void main(String[] args) {
        //Testing purposes
        char input = 'l';
        System.out.println("Input: " + validBS(input));
    }

    public static boolean validBS(char input) {
        if (input == '.' || input == 'S' || input == '*') {
            return true;
        } else {
            return false;
        }
    }
}
