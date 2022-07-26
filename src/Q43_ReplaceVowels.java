import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q43_ReplaceVowels {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please enter File Name : ");
        String fileName = sc.nextLine();

        while (true) {
            try (FileWriter file = new FileWriter(fileName)) {
                System.out.print("Please enter a String to be encrypted : ");
                String str = sc.nextLine();
                str = str.replaceAll("[aeiou]", "#");
                file.write(str);
            } catch (IOException e) {
                System.out.println("Error : Exception occurred => " + e.getMessage() + "\nTry Again..!");
                continue;
            }
            break;
        }
    }
}
