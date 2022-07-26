//Prog to accept a string from user and print the length of each word.
import java.util.Scanner;

public class WordLength {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please Enter some words : ");
        String str = sc.nextLine().trim();
        System.out.println("\n--- Word ---             --- Length ---");
        for (String i: str.split(" ")) {
            System.out.println(i+gap((i.length()<30)?30-i.length():2)+i.length());
        }
        System.out.println("----------------------------------------");
    }
    private static String gap(int len){
        StringBuilder gap = new StringBuilder();
        for (int i=0;i<len; i++) gap.append("-");
        return gap.toString();
    }
}
