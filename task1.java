public class task1 {

    public static boolean checkCharacter(char s){

        if (s != '*' && s != 'S' && s != '.') {
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        char s = '*';
        System.out.println(checkCharacter(s));
    }
}
