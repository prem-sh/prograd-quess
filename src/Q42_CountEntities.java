import java.util.Scanner;

//Accept string and count the number of alphabets, digits, spaces, special characters & words in the given string.
public class Q42_CountEntities {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int alphabets = 0;
        int digits = 0;
        int spaces = 0;
        int specialCharacters = 0;
        int words = 0;

        System.out.print("Please enter a String : ");
        String inp = sc.nextLine();
        for (char i:inp.toCharArray()) {
            if(isAlpha(i)) alphabets++;
            else if (isDigit(i)) digits++;
            else if (isSpace(i)) spaces++;
            else specialCharacters++;
        }
        words = countWords(inp);
        System.out.println("=====  String Report  =====");
        System.out.println("Alphabets         : "+alphabets);
        System.out.println("Digits            : "+digits);
        System.out.println("Spaces            : "+spaces);
        System.out.println("Special characters: "+specialCharacters);
        System.out.println("Words             : "+words);
        System.out.println("===========================");
    }

    private static int countWords(String str){
        return str.split(" ").length;
    }
    private static boolean isSpace(char c){
        return (c == ' ');
    }
    private static boolean isAlpha(char c){
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }
    private static boolean isDigit(char c){
        String digits = "0123456789";
        return digits.contains(String.valueOf(c));
    }
}
