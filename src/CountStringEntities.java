//Accept string and count lowercase, uppercase, vowels and consonant from given string
import java.util.Scanner;

public class CountStringEntities {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int lowercase = 0;
        int uppercase = 0;
        int vowels = 0;
        int consonant = 0;

        System.out.print("Please enter a String : ");
        String inp = sc.nextLine();
        for (char i:inp.toCharArray()) {

            if(isUpper(i)) uppercase++;
            else if (isLower(i)) lowercase++;

            if (isVowel(i)) vowels++;
            else if(isConsonant(i)) consonant++;

        }
        System.out.println("=====  String Report  =====");
        System.out.println("Lowercase         : "+lowercase);
        System.out.println("Uppercase         : "+uppercase);
        System.out.println("vowels            : "+vowels);
        System.out.println("consonant         : "+consonant);
        System.out.println("===========================");
    }


    private static boolean isLower(char c){
        return (c >= 'a' && c <= 'z');
    }
    private static boolean isUpper(char c){
        return (c >= 'A' && c <= 'Z');
    }
    private static boolean isVowel(char c){
        String digits = "aeiouAEIOU";
        return digits.contains(String.valueOf(c));
    }
    private static boolean isConsonant(char c){
        return !isVowel(c);
    }

}
